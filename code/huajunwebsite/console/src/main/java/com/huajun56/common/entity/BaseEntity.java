package com.huajun56.common.entity;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Base Entity for commonly attributes
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4209781713186148087L;

    /**
     * 是否删除(0:否，1：是)
     * b_user_role.is_del
     */
    private Boolean isDel;

    /**
     * 是否有效(0:有效，1：无效)
     * b_user_role.disabled
     */
    private Boolean disabled;

    private Date createDate;

    private Date updateDate;

    private String createBy;

    private String updateBy;

    public Boolean getIsDel(){
        return isDel;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setIsDel(Boolean del) {
        isDel = del;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
