package com.huajun56.shiro.util;


import com.huajun56.common.util.$;
import com.huajun56.shiro.entity.ShiroUser;
import com.huajun56.shiro.realm.ShiroAuthorizingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by Bond(China) on 2016/11/30.
 */
@Component
public class ShiroAuthorizationHelper {


    @Resource(name = "shiroCacheManager")
    private EhCacheManager cacheManager;

    @Resource(name = "shiroAuthorizingRealm")
    private ShiroAuthorizingRealm authorizingRealm;

    @Resource(name = "shiroSessionDAO")
    private SessionDAO shiroSessionDAO;

    /**
     * 重新加载权限
     *
     * @param username
     */
    public void reloadAuthorizing(String username) {
        Subject subject = SecurityUtils.getSubject();
        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(username, realmName);
        subject.runAs(principals);
        authorizingRealm.getAuthorizationCache().remove(subject.getPrincipals());
        subject.releaseRunAs();
    }

    /**
     * 强行踢出用户
     *
     * @param loginName
     */
    public void logout(String loginName) {
        Collection<Session> sessions = shiroSessionDAO.getActiveSessions();
        for (Session session : sessions) {
            ShiroUser shiroUser = (ShiroUser) ((SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).getPrimaryPrincipal();

            if ($.isEqual(loginName, shiroUser.getUserName())) {
                session.setTimeout(0);
                break;
            }
        }
    }

    /**
     * 清除当前用户的授权信息
     */
    //@Deprecated
    public void clearAuthenticationInfo() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            clearAuthenticationInfo(ShiroUser.getSessionUser().getUserName());
        }
    }

    /**
     * 清除用户的授权信息
     *
     * @param username
     */
    public void clearAuthenticationInfo(String username) {
        Cache<Object, Object> authenticationCache = cacheManager.getCache("authenticationCache");
        Cache<Object, Object> authorizationCache = cacheManager.getCache("authorizationCache");
        Cache<Object, Object> passwordRetryCache = cacheManager.getCache("passwordRetryCache");
        Cache<Object, Object> shiroActiveSessionCache = cacheManager.getCache("shiro-activeSessionCache");
        //Cache<Object, Object> realmCache = cacheManager.getCache(ShiroAuthorizingRealm.class.getSimpleName() + ".authorizationCache");
        authenticationCache.remove(username);
        authorizationCache.remove(username);
        passwordRetryCache.remove(username);
        shiroActiveSessionCache.remove(username);
        //realmCache.remove(username);
    }
}
