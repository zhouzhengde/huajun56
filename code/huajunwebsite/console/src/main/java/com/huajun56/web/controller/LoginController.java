package com.huajun56.web.controller;

import com.huajun56.common.base.BaseController;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.util.$;
import com.huajun56.common.util.Constants;
import com.huajun56.common.util.ExceptionCode;
import com.huajun56.shiro.entity.ShiroUser;
import com.huajun56.shiro.util.ShiroAuthorizationHelper;
import com.huajun56.web.entity.User;
import com.huajun56.web.service.ResourceService;
import com.huajun56.web.service.RoleResourceService;
import com.huajun56.web.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bond on 2017/2/26.
 */
@RestController
@RequestMapping("api/auth")
public class LoginController extends BaseController {

    @Autowired
    private RoleResourceService roleResourceService;

    @Autowired
    private ShiroAuthorizationHelper authorizationHelper;

    @RequestMapping(value = "login/{source}", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user, @PathVariable("source") Integer source) throws ServiceException {

        if ($.isEmpty(user.getUsername()) || $.isEmpty(user.getPassword())) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "用户名或密码错误！");
        }


        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(user.getUsername());
        token.setPassword(user.getPassword().toCharArray());

        SecurityUtils.getSubject().login(token);


        return success();
    }

    @RequestMapping(value = "islogin", method = RequestMethod.GET)
    public Map<String, Object> islogin() throws ServiceException {

        ShiroUser shiroUser = ShiroUser.getSessionUser();
        Map<String, Object> result = new HashMap<>();

        if ($.isNull(shiroUser)) {
            result.put("islogin", false);
            return success(result);
        }

        result.put("islogin", true);
        result.put("userInfo", shiroUser);
        return success(result);
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    @RequiresRoles("user")
    public Map<String, Object> menu() throws ServiceException {

//        ShiroUser shiroUser = ShiroUser.getSessionUser();
//
//        if ($.isNull(shiroUser.getRole()) || $.isEmpty(shiroUser.getRole().getRoleResourceList())) {
//            throw new ServiceException(ExceptionCode.ILLEGAL_ACCESS);
//        }

        return success(roleResourceService.generateMenuTree());
    }

    @RequestMapping(value = "logout ", method = RequestMethod.GET)
    @RequiresRoles("user")
    public Map<String, Object> logout() throws ServiceException {
        SecurityUtils.getSubject().logout();
        //authorizationHelper.clearAuthenticationInfo();
        return success(Constants.METHOD_EXEC_OK);
    }
}
