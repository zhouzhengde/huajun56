package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class Pay extends BaseEntity {
    /**
     * 主键ID
     * crm_pay.id
     */
    private String id;

    /**
     * 支付方式（0：现金代收，1：支付宝，2：微信，3：POS）
     * crm_pay.pay_type
     */
    private Integer payType;

    /**
     * 支付帐号
     * crm_pay.pay_account
     */
    private String payAccount;

    /**
     * 支付状态（0：待支付，1：已经支付）
     * crm_pay.pay_status
     */
    private Integer payStatus;

    /**
     * 支付金额
     * crm_pay.pay_money
     */
    private Double payMoney;

    /**
     * 是否有效（0：有效，1：无效）
     * crm_pay.disabled
     */
    private Boolean disabled;

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * crm_pay.is_del
     */
    private Boolean isDel;

    /**
     * 创建日期
     * crm_pay.create_date
     */
    private Date createDate;

    /**
     * 创建者
     * crm_pay.create_by
     */
    private String createBy;

    /**
     * 修改时期
     * crm_pay.update_date
     */
    private Date updateDate;

    /**
     * 修改者
     * crm_pay.update_by
     */
    private String updateBy;

    /**
     * 主键ID
     * @return the value of java.lang.String
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id * id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 支付方式（0：现金代收，1：支付宝，2：微信，3：POS）
     * @return the value of java.lang.Integer
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付方式（0：现金代收，1：支付宝，2：微信，3：POS）
     * @param payType * payType
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 支付帐号
     * @return the value of java.lang.String
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 支付帐号
     * @param payAccount * payAccount
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    /**
     * 支付状态（0：待支付，1：已经支付）
     * @return the value of java.lang.Integer
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态（0：待支付，1：已经支付）
     * @param payStatus * payStatus
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 支付金额
     * @return the value of java.lang.Double
     */
    public Double getPayMoney() {
        return payMoney;
    }

    /**
     * 支付金额
     * @param payMoney * payMoney
     */
    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
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