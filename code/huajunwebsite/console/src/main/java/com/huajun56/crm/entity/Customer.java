package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class Customer extends BaseEntity {
    /**
     * 主键ID
     * crm_customer.id
     */
    private Integer id;

    /**
     * 用户帐号
     * crm_customer.name
     */
    private String name;

    /**
     * 真实姓名
     * crm_customer.realname
     */
    private String realname;

    /**
     * 用为呢称
     * crm_customer.nickname
     */
    private String nickname;

    /**
     * 年龄
     * crm_customer.age
     */
    private Integer age;

    /**
     * 性别 
     * crm_customer.gender
     */
    private Integer gender;

    /**
     * 电话
     * crm_customer.tel
     */
    private String tel;

    /**
     * 手机
     * crm_customer.mobile
     */
    private String mobile;

    /**
     * 线路联系人微信
     * crm_customer.wechat
     */
    private String wechat;

    /**
     * 线路联系人QQ
     * crm_customer.qq
     */
    private String qq;

    /**
     * 国家编号
     * crm_customer.country_code
     */
    private String countryCode;

    /**
     * 
     * crm_customer.disabled
     */
    private Boolean disabled;

    /**
     * 
     * crm_customer.is_del
     */
    private Boolean isDel;

    /**
     * 创建时间
     * crm_customer.create_date
     */
    private Date createDate;

    /**
     * 创建人
     * crm_customer.create_by
     */
    private String createBy;

    /**
     * 更新时间
     * crm_customer.update_date
     */
    private Date updateDate;

    /**
     * 更新者
     * crm_customer.update_by
     */
    private String updateBy;

    /**
     * 
     * crm_customer.password
     */
    private String password;

    /**
     * 
     * crm_customer.salt
     */
    private String salt;

    /**
     * 更多客户信息
     * crm_customer.more_info
     */
    private String moreInfo;

    /**
     * 主键ID
     * @return the value of java.lang.Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户帐号
     * @return the value of java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * 用户帐号
     * @param name * name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 真实姓名
     * @return the value of java.lang.String
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 真实姓名
     * @param realname * realname
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 用为呢称
     * @return the value of java.lang.String
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 用为呢称
     * @param nickname * nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 年龄
     * @return the value of java.lang.Integer
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age * age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别 
     * @return the value of java.lang.Integer
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别 
     * @param gender * gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 电话
     * @return the value of java.lang.String
     */
    public String getTel() {
        return tel;
    }

    /**
     * 电话
     * @param tel * tel
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 手机
     * @return the value of java.lang.String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机
     * @param mobile * mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 线路联系人微信
     * @return the value of java.lang.String
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 线路联系人微信
     * @param wechat * wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * 线路联系人QQ
     * @return the value of java.lang.String
     */
    public String getQq() {
        return qq;
    }

    /**
     * 线路联系人QQ
     * @param qq * qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
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
     * 
     * @return the value of java.lang.String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password * password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return the value of java.lang.String
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 
     * @param salt * salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 更多客户信息
     * @return the value of java.lang.String
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * 更多客户信息
     * @param moreInfo * moreInfo
     */
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo == null ? null : moreInfo.trim();
    }
}