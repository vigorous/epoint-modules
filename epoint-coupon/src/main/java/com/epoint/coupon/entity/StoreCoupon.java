package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_coupon_store
 */
public class StoreCoupon extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 赠券ID
     */
    private Long couponId;

    /**
     * 领取数量
     */
    private Integer receiveNum;

    /**
     * 使用量
     */
    private Integer useNum;

    /**
     * 带来的订单金额
     */
    private Double orderMoney;

    /**
     * 适用门店ID
     */
    private Long applyStoreId;

    /**
     * 状态：0-启用，1-关闭
     */
    private Short couponStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
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

    public Long getApplyStoreId() {
        return applyStoreId;
    }

    public void setApplyStoreId(Long applyStoreId) {
        this.applyStoreId = applyStoreId;
    }


    public Short getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Short couponStatus) {
        this.couponStatus = couponStatus;
    }
}