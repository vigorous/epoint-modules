package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_check_bill
 */
public class CheckBill extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 单据号
     */
    private String billNo;

    /**
     * 在线支付总金额
     */
    private Double totalMoney;

    /**
     * 手续费
     */
    private Double handleCharge;

    /**
     * 提现金额
     */
    private Double cashOut;

    /**
     * 状态：0-待打款，1-已打款
     */
    private String status;

    /**
     * 所属门店ID
     */
    private Long storeId;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 开户名
     */
    private String accountName;

    /**
     * 银行账号
     */
    private String bankNo;

    /**
     * 打款人ID
     */
    private Long operatorId;

    /**
     * 打款时间
     */
    private Date operaterTime;

    /**
     * 银行流水号
     */
    private String serialNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getHandleCharge() {
        return handleCharge;
    }

    public void setHandleCharge(Double handleCharge) {
        this.handleCharge = handleCharge;
    }

    public Double getCashOut() {
        return cashOut;
    }

    public void setCashOut(Double cashOut) {
        this.cashOut = cashOut;
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperaterTime() {
        return operaterTime;
    }

    public void setOperaterTime(Date operaterTime) {
        this.operaterTime = operaterTime;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }
}