package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_check_bill_item
 */
public class CheckBillItem extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 支付宝支付金额
     */
    private Double alipayMoney;

    /**
     * 支付宝费率
     */
    private Double alipayRate;

    /**
     * 微信支付金额
     */
    private Double wxMoney;

    /**
     * 微信费率
     */
    private Double wxRate;

    /**
     * 状态：0-待打款，1-已打款
     */
    private String status;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 订单下单时间
     */
    private Date orderTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getAlipayMoney() {
        return alipayMoney;
    }

    public void setAlipayMoney(Double alipayMoney) {
        this.alipayMoney = alipayMoney;
    }

    public Double getAlipayRate() {
        return alipayRate;
    }

    public void setAlipayRate(Double alipayRate) {
        this.alipayRate = alipayRate;
    }

    public Double getWxMoney() {
        return wxMoney;
    }

    public void setWxMoney(Double wxMoney) {
        this.wxMoney = wxMoney;
    }

    public Double getWxRate() {
        return wxRate;
    }

    public void setWxRate(Double wxRate) {
        this.wxRate = wxRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}