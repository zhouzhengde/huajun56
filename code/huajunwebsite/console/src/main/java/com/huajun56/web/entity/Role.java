package com.huajun56.web.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;
import java.util.List;

public class Role extends BaseEntity {

    /**
     * 角色ID
     * web_role.id
     */
    private Integer id;

    /**
     * 角色名
     * web_role.name
     */
    private String name;

    private String code;

    private String alias;

    /**
     * 描述
     * web_role.description
     */
    private String description;


    /**
     * 更新者
     * web_role.update_by
     */
    private String updateBy;



    private List<RoleResource> roleResourceList;

    /**
     * 角色ID
     * @return the value of java.lang.Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 角色ID
     * @param id * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名
     * @return the value of java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名
     * @param name * name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述
     * @return the value of java.lang.String
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description * description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 更新者
     * @return the value of java.lang.String
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy * updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }


    public List<RoleResource> getRoleResourceList() {
        return roleResourceList;
    }

    public void setRoleResourceList(List<RoleResource> roleResourceList) {
        this.roleResourceList = roleResourceList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}