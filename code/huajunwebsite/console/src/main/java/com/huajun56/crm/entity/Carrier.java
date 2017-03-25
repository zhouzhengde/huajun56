package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class Carrier extends BaseEntity {
    /**
     * 
     * crm_carrier.id
     */
    private Integer id;

    /**
     * 公司全称
     * crm_carrier.name
     */
    private String name;

    /**
     * 公司所在省份
     * crm_carrier.province
     */
    private String province;

    /**
     * 公司所丰城市
     * crm_carrier.city
     */
    private String city;

    /**
     * 详细的联系地址
     * crm_carrier.address
     */
    private String address;

    /**
     * 公司总机
     * crm_carrier.tel
     */
    private String tel;

    /**
     * 公司负责人电话
     * crm_carrier.mobile
     */
    private String mobile;

    /**
     * 国家编号
     * crm_carrier.country_code
     */
    private String countryCode;

    /**
     * 公司直接联系人
     * crm_carrier.contact_people
     */
    private String contactPeople;

    /**
     * 
     * crm_carrier.disabled
     */
    private Boolean disabled;

    /**
     * 
     * crm_carrier.is_del
     */
    private Boolean isDel;

    /**
     * 创建时间
     * crm_carrier.create_date
     */
    private Date createDate;

    /**
     * 创建人
     * crm_carrier.create_by
     */
    private String createBy;

    /**
     * 更新时间
     * crm_carrier.update_date
     */
    private Date updateDate;

    /**
     * 更新者
     * crm_carrier.update_by
     */
    private String updateBy;

    /**
     * 更多公司信息
     * crm_carrier.more_info
     */
    private String moreInfo;

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
     * 公司全称
     * @return the value of java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * 公司全称
     * @param name * name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 公司所在省份
     * @return the value of java.lang.String
     */
    public String getProvince() {
        return province;
    }

    /**
     * 公司所在省份
     * @param province * province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 公司所丰城市
     * @return the value of java.lang.String
     */
    public String getCity() {
        return city;
    }

    /**
     * 公司所丰城市
     * @param city * city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 详细的联系地址
     * @return the value of java.lang.String
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细的联系地址
     * @param address * address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 公司总机
     * @return the value of java.lang.String
     */
    public String getTel() {
        return tel;
    }

    /**
     * 公司总机
     * @param tel * tel
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 公司负责人电话
     * @return the value of java.lang.String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 公司负责人电话
     * @param mobile * mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 国家编号
     * @return the value of java.lang.String
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 国家编号
     * @param countryCode * countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * 公司直接联系人
     * @return the value of java.lang.String
     */
    public String getContactPeople() {
        return contactPeople;
    }

    /**
     * 公司直接联系人
     * @param contactPeople * contactPeople
     */
    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople == null ? null : contactPeople.trim();
    }

    /**
     * 
     * @return the value of java.lang.Boolean
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * 
     * @param disabled * disabled
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 
     * @return the value of java.lang.Boolean
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 
     * @param isDel * isDel
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建时间
     * @return the value of java.util.Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate * createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建人
     * @return the value of java.lang.String
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy * createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 更新时间
     * @return the value of java.util.Date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate * updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    /**
     * 更多公司信息
     * @return the value of java.lang.String
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * 更多公司信息
     * @param moreInfo * moreInfo
     */
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo == null ? null : moreInfo.trim();
    }
}