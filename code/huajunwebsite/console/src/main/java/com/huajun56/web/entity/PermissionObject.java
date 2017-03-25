package com.huajun56.web.entity;

import java.io.Serializable;

/**
 * Created by bond on 2017/2/26.
 */
public class PermissionObject implements Serializable {
    private Boolean access = false;
    private Boolean query = false;
    private Boolean add = false;
    private Boolean delete = false;
    private Boolean modify = false;

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public Boolean getQuery() {
        return query;
    }

    public void setQuery(Boolean query) {
        this.query = query;
    }

    public Boolean getAdd() {
        return add;
    }

    public void setAdd(Boolean add) {
        this.add = add;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getModify() {
        return modify;
    }

    public void setModify(Boolean modify) {
        this.modify = modify;
    }
}