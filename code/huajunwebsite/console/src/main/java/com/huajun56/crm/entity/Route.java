package com.huajun56.crm.entity;

import com.huajun56.common.entity.BaseEntity;
import java.util.Date;

public class Route extends BaseEntity {
    /**
     * 
     * crm_route.id
     */
    private Integer id;

    /**
     * 出发地所属省份编号
     * crm_route.from_province
     */
    private String fromProvince;

    /**
     * 出发地所属城市编号
     * crm_route.from_city
     */
    private String fromCity;

    /**
     * 发货仓库点
     * crm_route.from_storage
     */
    private String fromStorage;

    /**
     * 出发地经度
     * crm_route.from_lng
     */
    private Double fromLng;

    /**
     * 出发地纬度
     * crm_route.from_lat
     */
    private Double fromLat;

    /**
     * 目的地所属省份编号（终点站）
     * crm_route.to_province
     */
    private String toProvince;

    /**
     * 目的地所属城市编号（终点站）
     * crm_route.to_city
     */
    private String toCity;

    /**
     * 终点站仓库点
     * crm_route.to_storage
     */
    private String toStorage;

    /**
     * 终点站经度
     * crm_route.to_lng
     */
    private Double toLng;

    /**
     * 终点站纬度
     * crm_route.to_lat
     */
    private Double toLat;

    /**
     * 线路的里程（KM）
     * crm_route.distance
     */
    private Integer distance;

    /**
     * 线路类型（0：综合，1：汽车运输，2：铁路运输，3：空运，4：海运）
     * crm_route.route_type
     */
    private Integer routeType;

    /**
     * 途经站点
     * crm_route.route_trace
     */
    private String routeTrace;

    /**
     * 承运单位的ID
     * crm_route.carrier_id
     */
    private Integer carrierId;

    /**
     * 线路联系人
     * crm_route.contact_people
     */
    private String contactPeople;

    /**
     * 线路联系手机
     * crm_route.contact_mobile
     */
    private String contactMobile;

    /**
     * 线路联系人电话
     * crm_route.contact_tel
     */
    private String contactTel;

    /**
     * 线路联系人微信
     * crm_route.contact_wechat
     */
    private String contactWechat;

    /**
     * 线路联系人QQ
     * crm_route.contact_qq
     */
    private String contactQq;

    /**
     * 更多联系信息
     * crm_route.more_info
     */
    private String moreInfo;

    /**
     * 是否有效（0：有效，1：无效）
     * crm_route.disabled
     */
    private Boolean disabled;

    /**
     * 是否删除（0：没有删除，1：已经删除）
     * crm_route.is_del
     */
    private Boolean isDel;

    /**
     * 创建日期
     * crm_route.create_date
     */
    private Date createDate;

    /**
     * 创建者
     * crm_route.create_by
     */
    private String createBy;

    /**
     * 更新日期
     * crm_route.update_date
     */
    private Date updateDate;

    /**
     * 更新者
     * crm_route.update_by
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
     * 出发地所属省份编号
     * @return the value of java.lang.String
     */
    public String getFromProvince() {
        return fromProvince;
    }

    /**
     * 出发地所属省份编号
     * @param fromProvince * fromProvince
     */
    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince == null ? null : fromProvince.trim();
    }

    /**
     * 出发地所属城市编号
     * @return the value of java.lang.String
     */
    public String getFromCity() {
        return fromCity;
    }

    /**
     * 出发地所属城市编号
     * @param fromCity * fromCity
     */
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity == null ? null : fromCity.trim();
    }

    /**
     * 发货仓库点
     * @return the value of java.lang.String
     */
    public String getFromStorage() {
        return fromStorage;
    }

    /**
     * 发货仓库点
     * @param fromStorage * fromStorage
     */
    public void setFromStorage(String fromStorage) {
        this.fromStorage = fromStorage == null ? null : fromStorage.trim();
    }

    /**
     * 出发地经度
     * @return the value of java.lang.Double
     */
    public Double getFromLng() {
        return fromLng;
    }

    /**
     * 出发地经度
     * @param fromLng * fromLng
     */
    public void setFromLng(Double fromLng) {
        this.fromLng = fromLng;
    }

    /**
     * 出发地纬度
     * @return the value of java.lang.Double
     */
    public Double getFromLat() {
        return fromLat;
    }

    /**
     * 出发地纬度
     * @param fromLat * fromLat
     */
    public void setFromLat(Double fromLat) {
        this.fromLat = fromLat;
    }

    /**
     * 目的地所属省份编号（终点站）
     * @return the value of java.lang.String
     */
    public String getToProvince() {
        return toProvince;
    }

    /**
     * 目的地所属省份编号（终点站）
     * @param toProvince * toProvince
     */
    public void setToProvince(String toProvince) {
        this.toProvince = toProvince == null ? null : toProvince.trim();
    }

    /**
     * 目的地所属城市编号（终点站）
     * @return the value of java.lang.String
     */
    public String getToCity() {
        return toCity;
    }

    /**
     * 目的地所属城市编号（终点站）
     * @param toCity * toCity
     */
    public void setToCity(String toCity) {
        this.toCity = toCity == null ? null : toCity.trim();
    }

    /**
     * 终点站仓库点
     * @return the value of java.lang.String
     */
    public String getToStorage() {
        return toStorage;
    }

    /**
     * 终点站仓库点
     * @param toStorage * toStorage
     */
    public void setToStorage(String toStorage) {
        this.toStorage = toStorage == null ? null : toStorage.trim();
    }

    /**
     * 终点站经度
     * @return the value of java.lang.Double
     */
    public Double getToLng() {
        return toLng;
    }

    /**
     * 终点站经度
     * @param toLng * toLng
     */
    public void setToLng(Double toLng) {
        this.toLng = toLng;
    }

    /**
     * 终点站纬度
     * @return the value of java.lang.Double
     */
    public Double getToLat() {
        return toLat;
    }

    /**
     * 终点站纬度
     * @param toLat * toLat
     */
    public void setToLat(Double toLat) {
        this.toLat = toLat;
    }

    /**
     * 线路的里程（KM）
     * @return the value of java.lang.Integer
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * 线路的里程（KM）
     * @param distance * distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * 线路类型（0：综合，1：汽车运输，2：铁路运输，3：空运，4：海运）
     * @return the value of java.lang.Integer
     */
    public Integer getRouteType() {
        return routeType;
    }

    /**
     * 线路类型（0：综合，1：汽车运输，2：铁路运输，3：空运，4：海运）
     * @param routeType * routeType
     */
    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    /**
     * 途经站点
     * @return the value of java.lang.String
     */
    public String getRouteTrace() {
        return routeTrace;
    }

    /**
     * 途经站点
     * @param routeTrace * routeTrace
     */
    public void setRouteTrace(String routeTrace) {
        this.routeTrace = routeTrace == null ? null : routeTrace.trim();
    }

    /**
     * 承运单位的ID
     * @return the value of java.lang.Integer
     */
    public Integer getCarrierId() {
        return carrierId;
    }

    /**
     * 承运单位的ID
     * @param carrierId * carrierId
     */
    public void setCarrierId(Integer carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * 线路联系人
     * @return the value of java.lang.String
     */
    public String getContactPeople() {
        return contactPeople;
    }

    /**
     * 线路联系人
     * @param contactPeople * contactPeople
     */
    public void setContactPeople(String contactPeople) {
        this.contactPeople = contactPeople == null ? null : contactPeople.trim();
    }

    /**
     * 线路联系手机
     * @return the value of java.lang.String
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * 线路联系手机
     * @param contactMobile * contactMobile
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    /**
     * 线路联系人电话
     * @return the value of java.lang.String
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 线路联系人电话
     * @param contactTel * contactTel
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 线路联系人微信
     * @return the value of java.lang.String
     */
    public String getContactWechat() {
        return contactWechat;
    }

    /**
     * 线路联系人微信
     * @param contactWechat * contactWechat
     */
    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat == null ? null : contactWechat.trim();
    }

    /**
     * 线路联系人QQ
     * @return the value of java.lang.String
     */
    public String getContactQq() {
        return contactQq;
    }

    /**
     * 线路联系人QQ
     * @param contactQq * contactQq
     */
    public void setContactQq(String contactQq) {
        this.contactQq = contactQq == null ? null : contactQq.trim();
    }

    /**
     * 更多联系信息
     * @return the value of java.lang.String
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * 更多联系信息
     * @param moreInfo * moreInfo
     */
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo == null ? null : moreInfo.trim();
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
     * 更新日期
     * @return the value of java.util.Date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新日期
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
}