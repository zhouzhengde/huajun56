package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class Country extends BaseEntity {
    /**
     * 
     * crm_country.id
     */
    private Integer id;

    /**
     * 国家编号
     * crm_country.code
     */
    private String code;

    /**
     * 国家的英文
     * crm_country.name_en
     */
    private String nameEn;

    /**
     * 国家名称中文
     * crm_country.name_cn
     */
    private String nameCn;

    /**
     * 是否有效（0：有效，1：无效）
     * crm_country.disabled
     */
    private Boolean disabled;

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * crm_country.is_del
     */
    private Boolean isDel;

    /**
     * 创建日期
     * crm_country.create_date
     */
    private Date createDate;

    /**
     * 创建者
     * crm_country.create_by
     */
    private String createBy;

    /**
     * 修改时期
     * crm_country.update_date
     */
    private Date updateDate;

    /**
     * 修改者
     * crm_country.update_by
     */
    private String updateBy;

    /**
     * 
     * @return the value of java.lang.Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 国家编号
     * @return the value of java.lang.String
     */
    public String getCode() {
        return code;
    }

    /**
     * 国家编号
     * @param code * code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 国家的英文
     * @return the value of java.lang.String
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 国家的英文
     * @param nameEn * nameEn
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * 国家名称中文
     * @return the value of java.lang.String
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     * 国家名称中文
     * @param nameCn * nameCn
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    /**
     * 是否有效（0：有效，1：无效）
     * @return the value of java.lang.Boolean
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * 是否有效（0：有效，1：无效）
     * @param disabled * disabled
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * @return the value of java.lang.Boolean
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * @param isDel * isDel
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建日期
     * @return the value of java.util.Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate * createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建者
     * @return the value of java.lang.String
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy * createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 修改时期
     * @return the value of java.util.Date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时期
     * @param updateDate * updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 修改者
     * @return the value of java.lang.String
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改者
     * @param updateBy * updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}