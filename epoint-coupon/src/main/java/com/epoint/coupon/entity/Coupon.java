package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 表名:erp_coupon
 */
public class Coupon extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 赠券名称
     */
    private String name;

    /**
     * 赠券类型:1-现金
     */
    private Short type;

    /**
     * 发行数量:-1-无限
     */
    private Integer publishNum;

    /**
     * 赠券金额
     */
    private Double couponMoney;

    /**
     * 赠券内容
     */
    private String content;

    /**
     * 是否自动发放：0-否，1-是
     */
    private Short regAutoSend;

    /**
     * 分享数量
     */
    private Integer shareNum;

    /**
     * 创建门店ID
     */
    private Long storeId;

    /**
     * 状态：0-启用，1-关闭
     */
    @Deprecated
    private Short status;

    /**
     * 有效开始时间
     */
    private Date startTime;

    /**
     * 有效结束时间
     */
    private Date endTime;

    /**
     * 领取数量
     */
    private Integer receiveNum;

    /**
     * 使用数量
     */
    private Integer useNum;

    /**
     * 关联的订单总金额
     */
    private Double orderMoney;

    /**
     * 关联的项目或商品ID,现金券该字段为NULL
     */
    private Long itemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(Integer publishNum) {
        this.publishNum = publishNum;
    }

    public Double getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getRegAutoSend() {
        return regAutoSend;
    }

    public void setRegAutoSend(Short regAutoSend) {
        this.regAutoSend = regAutoSend;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(Integer receiveNum) {
        this.receiveNum = receiveNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}