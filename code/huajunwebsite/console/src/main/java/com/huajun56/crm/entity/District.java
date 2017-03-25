package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class District extends BaseEntity {
    /**
     * 
     * crm_district.id
     */
    private Integer id;

    /**
     * 
     * crm_district.code
     */
    private String code;

    /**
     * 
     * crm_district.name
     */
    private String name;

    /**
     * 
     * crm_district.name_en
     */
    private String nameEn;

    /**
     * 
     * crm_district.shortname_en
     */
    private String shortnameEn;

    /**
     * 地区的类型（1：省级、州、直辖市， 2：市级、直辖市的区，3：县级）
     * crm_district.level
     */
    private Integer level;

    /**
     * 
     * crm_district.order
     */
    private Integer order;

    /**
     * 
     * crm_district.parent_id
     */
    private Integer parentId;

    /**
     * 
     * crm_district.country_code
     */
    private String countryCode;

    /**
     * 是否有效（0：有效，1：无效）
     * crm_district.disabled
     */
    private Boolean disabled;

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * crm_district.is_del
     */
    private Boolean isDel;

    /**
     * 创建日期
     * crm_district.create_date
     */
    private Date createDate;

    /**
     * 创建者
     * crm_district.create_by
     */
    private String createBy;

    /**
     * 修改时期
     * crm_district.update_date
     */
    private Date updateDate;

    /**
     * 修改者
     * crm_district.update_by
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
     * 
     * @return the value of java.lang.String
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code * code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 
     * @return the value of java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name * name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return the value of java.lang.String
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 
     * @param nameEn * nameEn
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * 
     * @return the value of java.lang.String
     */
    public String getShortnameEn() {
        return shortnameEn;
    }

    /**
     * 
     * @param shortnameEn * shortnameEn
     */
    public void setShortnameEn(String shortnameEn) {
        this.shortnameEn = shortnameEn == null ? null : shortnameEn.trim();
    }

    /**
     * 地区的类型（1：省级、州、直辖市， 2：市级、直辖市的区，3：县级）
     * @return the value of java.lang.Integer
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 地区的类型（1：省级、州、直辖市， 2：市级、直辖市的区，3：县级）
     * @param level * level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 
     * @return the value of java.lang.Integer
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 
     * @param order * order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 
     * @return the value of java.lang.Integer
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId * parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * @return the value of java.lang.String
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode * countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
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