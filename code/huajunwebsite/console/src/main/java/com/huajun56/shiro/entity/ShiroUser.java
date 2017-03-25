package com.huajun56.shiro.entity;

import com.huajun56.common.util.$;
import com.huajun56.web.entity.Role;
import org.apache.shiro.SecurityUtils;

import java.io.Serializable;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 * Created by Bond(China) on 2016/11/9.
 */
public class ShiroUser implements Serializable, Cloneable {

    private static final long serialVersionUID = -1373760761780840081L;
    private Integer id;
    private String userName;
    private String realName;
    private String nickName;
    private String headPhoto;

    private Role role;

    public ShiroUser() {
    }

    public ShiroUser(Integer id, String userName, String realName, String nickName, String headPhoto) {
        this.id = id;
        this.userName = userName;
        this.realName = realName;
        this.nickName = nickName;
        this.headPhoto = headPhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public boolean equals(Object obj) {
        if ($.isNull(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ShiroUser other = (ShiroUser) obj;
        if (this.getClass() != obj.getClass() || !$.isEqual(this.userName, other.userName)) {
            return false;
        }
        if($.isEqual(this.getId(), other.getId())){
            return  false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * 获取当前会话中的User
     *
     * @return
     */
    public static ShiroUser getSessionUser() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }

}
