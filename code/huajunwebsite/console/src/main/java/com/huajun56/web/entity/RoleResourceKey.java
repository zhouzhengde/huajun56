package com.huajun56.web.entity;

import com.huajun56.common.entity.BaseEntity;

public class RoleResourceKey extends BaseEntity {

    private Long id;

    private Integer roleId;

    private Integer resourceId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}