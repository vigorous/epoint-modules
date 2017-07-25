package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_order_delay_repay
 */
public class OrderDelayRepay extends BaseEntity {
    private Long id;

    /**
     * 还款单号
     */
    private String repayNo;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 实际支付 = 欠款减优惠金额
     */
    private Double actualMoney;

    /**
     * 还款优惠金额
     */
    private Double privilege;

    /**
     * 销账金额
     */
    private Double balanceAmount;

    /**
     * 还款客户id
     */
    private Long memberId;

    private Long storeId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 销帐类型: 1 期初欠款 2 挂帐 3 期初欠款、挂账都有
     */
    private Short type;

    /**
     * 父门店id
     */
    private Long parentStoreId;

    /**
     * 收取金额
     */
    private Double getMoney;

    /**
     * 支付方式
     */
    private String payWay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepayNo() {
        return repayNo;
    }

    public void setRepayNo(String repayNo) {
        this.repayNo = repayNo;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Double getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Double privilege) {
        this.privilege = privilege;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Double getGetMoney() {
        return getMoney;
    }

    public void setGetMoney(Double getMoney) {
        this.getMoney = getMoney;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}