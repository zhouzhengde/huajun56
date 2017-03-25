package com.huajun56.web.entity;

import com.huajun56.common.util.$;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.Permission;

public class RoleResource extends RoleResourceKey implements Comparable, Permission {

    private String permission;

    /**
     *
     */
    private PermissionObject permissionObject;

    private Resource resource;

    public String getPermission() {
        return permission;
    }

    /**
     * 权限信息
     *
     * @param permission * permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
        if ($.isNull(permission)) {
            permissionObject = null;
            return;
        }
        JSONObject jsonObject = JSONObject.fromObject(permission);
        this.permissionObject = (PermissionObject) JSONObject.toBean(jsonObject, PermissionObject.class);
    }

    public void setPermissionObject(PermissionObject permissionObject) {
        if ($.isNull(permissionObject)) {
            permission = null;
            permissionObject = null;
            return;
        }
        permission = JSONObject.fromObject(permissionObject).toString();
        this.permissionObject = permissionObject;
    }


    @Override
    public boolean equals(Object obj) {

        RoleResource other = null;

        if (obj instanceof RoleResource) {
            other = (RoleResource) obj;
        }

        if ($.isNull(other)) {
            return false;
        }

        if ($.isEqual(this.getRoleId(), other.getRoleId()) && $.isEqual(this.getResourceId(), other.getResourceId())) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {

        if ($.isNull(getResourceId()) || $.isNull(getRoleId())) {
            return super.hashCode();
        } else {
            return getRoleId() << 2 + getResourceId() << 3;
        }
    }

    @Override
    public int compareTo(Object obj) {

        RoleResource other = null;

        if (obj instanceof RoleResource) {
            other = (RoleResource) obj;
        }

        if ($.isNull(other)) {
            return 0;
        }

        Integer thisVal = this.getRoleId() << 2 + getResourceId() << 3;
        Integer otherVal = other.getRoleId() << 2 + other.getResourceId() << 3;

        return thisVal - otherVal;
    }

    @Override
    public boolean implies(Permission permission) {
        return true;
    }

    public PermissionObject getPermissionObject() {
        return permissionObject;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }


}