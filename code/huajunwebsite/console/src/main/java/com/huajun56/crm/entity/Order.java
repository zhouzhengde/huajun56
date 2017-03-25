package com.huajun56.crm.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huajun56.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class Order extends BaseEntity {
    /**
     * 主键ID
     * crm_order.id
     */
    private String id;

    /**
     * 支付ID
     * crm_order.pay_id
     */
    private String payId;

    /**
     * 客户ID
     * crm_order.customer_id
     */
    private Integer customerId;

    /**
     * 订单类型，0：其它，1：个人类型，2：企业类型/组织机构
     * crm_order.order_type
     */
    @ApiModelProperty(notes = "0：其它，1：个人类型，2：企业类型/组织机构")
    private Integer orderType;

    /**
     * 搬运公司ID
     * crm_order.carrier_id
     */
    private Integer carrierId;

    /**
     * 订单状态（0：保存，1：下单，2：待发货，3：已揽件，4：运输中，5：到达目的站，6：待收件，7：异常件，8：客户拒收，9：已收货，10：已支付）
     * crm_order.status
     */
    @ApiModelProperty(notes = "0：保存，1：下单，2：待发货，3：已揽件，4：运输中，5：到达目的站，6：待收件，7：异常件，8：客户拒收，9：已收货，10：已支付")
    private Integer status;

    /**
     * 寄件的发货省份编号
     * crm_order.from_province
     */
    private String fromProvince;

    /**
     * 寄件的发货城市编号
     * crm_order.from_city
     */
    private String fromCity;

    /**
     * 寄件的发货详细地址
     * crm_order.from_address
     */
    @ApiModelProperty(notes = "发货详细地址")
    private String fromAddress;

    /**
     * 收货货省份编号
     * crm_order.to_province
     */
    private String toProvince;

    /**
     * 收货城市编号
     * crm_order.to_city
     */
    private String toCity;

    /**
     * 收货详细地址
     * crm_order.to_address
     */
    @ApiModelProperty(notes = "收货详细地址")
    private String toAddress;

    /**
     * 重量（单位：KG）
     * crm_order.weight
     */
    @ApiModelProperty(notes = "物件重量（KG）")
    private Double weight;

    /**
     * 体积（单位：立方）
     * crm_order.volume
     */
    @ApiModelProperty(notes = "物件体积（m^3）")
    private Double volume;

    /**
     * 线路ID
     * crm_order.route_id
     */
    private Integer routeId;

    /**
     * 计价类型（0：综合，1：按体积，2：按重量，3：按路途）
     * crm_order.price_type
     */
    private Integer priceType;

    /**
     * 订单预报价金额 （元）
     * crm_order.quoted_price
     */
    private Double quotedPrice;

    /**
     * 成交价
     * crm_order.final_price
     */
    private Double finalPrice;

    /**
     * 是否有效（0：有效，1：无效）
     * crm_order.disabled
     */
    private Boolean disabled;

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * crm_order.is_del
     */
    private Boolean isDel;

    /**
     * 创建日期
     * crm_order.create_date
     */
    private Date createDate;

    /**
     * 创建者
     * crm_order.create_by
     */
    private String createBy;

    /**
     * 修改时期
     * crm_order.update_date
     */
    private Date updateDate;

    /**
     * 修改者
     * crm_order.update_by
     */
    private String updateBy;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "发货人手机号码", required = true)
    private String fromMobile;

    private String toMobile;

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "发货人真实姓名", required = true)
    private String fromRealname;

    private String toRealname;

    private Customer customer;

    /**
     * 主键ID
     *
     * @return the value of java.lang.String
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     *
     * @param id * id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 支付ID
     *
     * @return the value of java.lang.String
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 支付ID
     *
     * @param payId * payId
     */
    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    /**
     * 客户ID
     *
     * @return the value of java.lang.Integer
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 客户ID
     *
     * @param customerId * customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 订单类型，0：其它，1：个人类型，2：企业类型/组织机构
     *
     * @return the value of java.lang.Integer
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 订单类型，0：其它，1：个人类型，2：企业类型/组织机构
     *
     * @param orderType * orderType
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 搬运公司ID
     *
     * @return the value of java.lang.Integer
     */
    public Integer getCarrierId() {
        return carrierId;
    }

    /**
     * 搬运公司ID
     *
     * @param carrierId * carrierId
     */
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * 订单状态（0：保存，1：下单，2：待发货，3：已揽件，4：运输中，5：到达目的站，6：待收件，7：异常件，8：客户拒收，9：已收货，10：已支付）
     *
     * @return the value of java.lang.Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态（0：保存，1：下单，2：待发货，3：已揽件，4：运输中，5：到达目的站，6：待收件，7：异常件，8：客户拒收，9：已收货，10：已支付）
     *
     * @param status * status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 寄件的发货省份编号
     *
     * @return the value of java.lang.String
     */
    public String getFromProvince() {
        return fromProvince;
    }

    /**
     * 寄件的发货省份编号
     *
     * @param fromProvince * fromProvince
     */
    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince == null ? null : fromProvince.trim();
    }

    /**
     * 寄件的发货城市编号
     *
     * @return the value of java.lang.String
     */
    public String getFromCity() {
        return fromCity;
    }

    /**
     * 寄件的发货城市编号
     *
     * @param fromCity * fromCity
     */
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity == null ? null : fromCity.trim();
    }

    /**
     * 寄件的发货详细地址
     *
     * @return the value of java.lang.String
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * 寄件的发货详细地址
     *
     * @param fromAddress * fromAddress
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    /**
     * 收货货省份编号
     *
     * @return the value of java.lang.String
     */
    public String getToProvince() {
        return toProvince;
    }

    /**
     * 收货货省份编号
     *
     * @param toProvince * toProvince
     */
    public void setToProvince(String toProvince) {
        this.toProvince = toProvince == null ? null : toProvince.trim();
    }

    /**
     * 收货城市编号
     *
     * @return the value of java.lang.String
     */
    public String getToCity() {
        return toCity;
    }

    /**
     * 收货城市编号
     *
     * @param toCity * toCity
     */
    public void setToCity(String toCity) {
        this.toCity = toCity == null ? null : toCity.trim();
    }

    /**
     * 收货详细地址
     *
     * @return the value of java.lang.String
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * 收货详细地址
     *
     * @param toAddress * toAddress
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? null : toAddress.trim();
    }

    /**
     * 重量（单位：KG）
     *
     * @return the value of java.lang.Double
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 重量（单位：KG）
     *
     * @param weight * weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 体积（单位：立方）
     *
     * @return the value of java.lang.Double
     */
    public Double getVolume() {
        return volume;
    }

    /**
     * 体积（单位：立方）
     *
     * @param volume * volume
     */
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    /**
     * 线路ID
     *
     * @return the value of java.lang.Integer
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * 线路ID
     *
     * @param routeId * routeId
     */
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    /**
     * 计价类型（0：综合，1：按体积，2：按重量，3：按路途）
     *
     * @return the value of java.lang.Integer
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * 计价类型（0：综合，1：按体积，2：按重量，3：按路途）
     *
     * @param priceType * priceType
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * 订单预报价金额 （元）
     *
     * @return the value of java.lang.Double
     */
    public Double getQuotedPrice() {
        return quotedPrice;
    }

    /**
     * 订单预报价金额 （元）
     *
     * @param quotedPrice * quotedPrice
     */
    public void setQuotedPrice(Double quotedPrice) {
        this.quotedPrice = quotedPrice;
    }

    /**
     * 成交价
     *
     * @return the value of java.lang.Double
     */
    public Double getFinalPrice() {
        return finalPrice;
    }

    /**
     * 成交价
     *
     * @param finalPrice * finalPrice
     */
    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * 是否有效（0：有效，1：无效）
     *
     * @return the value of java.lang.Boolean
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * 是否有效（0：有效，1：无效）
     *
     * @param disabled * disabled
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 是否删除（0：没有删除，1：已经删除）
     *
     * @return the value of java.lang.Boolean
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 是否删除（0：没有删除，1：已经删除）
     *
     * @param isDel * isDel
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建日期
     *
     * @return the value of java.util.Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     *
     * @param createDate * createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建者
     *
     * @return the value of java.lang.String
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     *
     * @param createBy * createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 修改时期
     *
     * @return the value of java.util.Date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时期
     *
     * @param updateDate * updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 修改者
     *
     * @return the value of java.lang.String
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改者
     *
     * @param updateBy * updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFromMobile() {
        return fromMobile;
    }

    public void setFromMobile(String fromMobile) {
        this.fromMobile = fromMobile;
    }

    public String getToMobile() {
        return toMobile;
    }

    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    public String getFromRealname() {
        return fromRealname;
    }

    public void setFromRealname(String fromRealname) {
        this.fromRealname = fromRealname;
    }

    public String getToRealname() {
        return toRealname;
    }

    public void setToRealname(String toRealname) {
        this.toRealname = toRealname;
    }
}