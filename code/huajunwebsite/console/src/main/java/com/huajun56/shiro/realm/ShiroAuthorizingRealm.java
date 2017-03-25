package com.huajun56.shiro.realm;


import com.huajun56.common.entity.Pager;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.util.$;
import com.huajun56.common.util.BeanUtils;
import com.huajun56.common.util.ExceptionCode;
import com.huajun56.shiro.entity.ShiroUser;
import com.huajun56.web.entity.Role;
import com.huajun56.web.entity.RoleResource;
import com.huajun56.web.entity.User;
import com.huajun56.web.service.RoleResourceService;
import com.huajun56.web.service.RoleService;
import com.huajun56.web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ShiroAuthorizingRealm extends AuthorizingRealm {


    private UserService usersService;


    private RoleResourceService roleResourceService;


    public RoleResourceService getRoleResourceService() {
        if ($.isNull(roleResourceService)) {
            roleResourceService = BeanUtils.getBean(RoleResourceService.class);
        }
        return roleResourceService;
    }

    public UserService getUsersService() {

        if ($.isNull(usersService)) {
            usersService = BeanUtils.getBean(UserService.class);
        }
        return usersService;
    }

    private RoleService roleService;

    public RoleService getRoleService() {
        if ($.isNull(roleService)) {
            roleService = BeanUtils.getBean(RoleService.class);
        }
        return roleService;
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        return getAuthenticationInfo(token);
    }

    private AuthenticationInfo getAuthenticationInfo(UsernamePasswordToken token) {
        User user = null;
        try {
            user = new User();
            user.setUsername(token.getUsername());
            user = getUsersService().findOne(user);
            if ($.isNull(user)) {
                throw new ServiceException(ExceptionCode.ILLEGAL_ACCESS.getCode(), "未知帐号尝试登入！");
            }
            setResource(user);
        } catch (ServiceException e) {
            throw new UnknownAccountException(e);
        }

        byte[] salt = Hex.decode(user.getSalt());

        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getRealname(), user.getRealname(), null);
        shiroUser.setRole(user.getRole());
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword(), ByteSource.Util.bytes(salt), getName());

    }

    private void setResource(User user) throws ServiceException {

        Pager<RoleResource> pager = new Pager<>();
        RoleResource roleResource = new RoleResource();
        roleResource.setIsDel(false);
        roleResource.setRoleId(user.getRoleId());
        pager.setCondition(roleResource);
        pager.setPageSize(Integer.MAX_VALUE);
        List<RoleResource> roleResourceList = getRoleResourceService().findByPager(pager).getResult();
        user.getRole().setRoleResourceList(roleResourceList);
    }

    /**
     * 授权查询回调函数, 进行鉴权当缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 构建资源权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("user");
        return info;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}