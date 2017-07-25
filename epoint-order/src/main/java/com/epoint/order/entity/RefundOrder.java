package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_refund_order
 */
public class RefundOrder extends BaseEntity {
    private Long id;

    private String orderNo;

    private String status;

    private Long seller;

    private Double totalMoney;

    private Double actualMoney;

    private Long storeId;

    private Long memberId;

    private Long workAreaId;

    private String carNo;

    private String remark;

    private String payWay;

    private Long orderStaffId;

    private Date startTime;

    private Date endTime;

    /**
     * 是否评论
     */
    private Boolean isComment;

    private String channel;

    private String bookingTime;

    private String payChannel;

    private String orderType;

    /**
     * 针对商品订单是否领取0未领取1已领取
     */
    private Boolean isReceive;

    private Long ext1;

    private String remark2;

    private String deviceCode;

    private Double payWayMoney;

    private Double getMoney;

    private Double backMoney;

    private Long creator;

    private String creatorType;

    /**
     * app端>我的收藏>是否取消交易过的门店(默认为空代表未取消,1代表已取消)
     */
    private String cancelTradedMark;

    private Integer orderAssessmentStar;

    /**
     * 是否自动下单扣款。1：是；0:否。自动洗车订单使用该字段
     */
    private Integer autoDeduct;

    private String otherSystemOrderNo;

    /**
     * 0:未支付;1:挂账;2:支付中;3:支付失败;4:支付成功;
     */
    private Integer payStatus;

    /**
     * 父门店ID
     */
    private Integer parentStoreId;

    /**
     * 预收金额
     */
    private Double preAmount;

    /**
     * 在哪个端口发起支付。1:erp;2:weixin;
     */
    private Integer payFrom;

    /**
     * 车辆ID
     */
    private Integer carId;

    /**
     * 验车ID
     */
    private Integer carCheckId;

    /**
     * 是否返工。1:是;0:否
     */
    private Integer rework;

    /**
     * 微信或支付宝的交易流水号
     */
    private String transactionId;

    /**
     * 在线支付时商户订单号，可能同订单号一样
     */
    private String outTradeNo;

    /**
     * 预支付时:微信或支付宝的交易流水号
     */
    private String preTransactionId;

    /**
     * 预支付时:在线支付时商户订单号，可能同订单号一样
     */
    private String preOutTradeNo;

    /**
     * 挂账还款表id  有值时，表明此订单为挂账还款订单
     */
    private Long delayRepayId;

    /**
     * 20161122前的挂账订单标记；0：表示新的挂账订单；1：表示上线前的挂账订单
     */
    private Short oldOrder;

    /**
     * 进场时间
     */
    private Date entryTime;

    /**
     * 交车时间
     */
    private Date finishTime;

    /**
     * 客户描述
     */
    private String memberDesc;

    /**
     * 领料人
     */
    private Long getStaffId;

    /**
     * 出库人
     */
    private Long outStaffId;

    /**
     * 反结算时间
     */
    private Date refundTime;

    /**
     * 反结算操作人
     */
    private Long refundStaffId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getWorkAreaId() {
        return workAreaId;
    }

    public void setWorkAreaId(Long workAreaId) {
        this.workAreaId = workAreaId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Long getOrderStaffId() {
        return orderStaffId;
    }

    public void setOrderStaffId(Long orderStaffId) {
        this.orderStaffId = orderStaffId;
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

    public Boolean getIsComment() {
        return isComment;
    }

    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Boolean getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(Boolean isReceive) {
        this.isReceive = isReceive;
    }

    public Long getExt1() {
        return ext1;
    }

    public void setExt1(Long ext1) {
        this.ext1 = ext1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Double getPayWayMoney() {
        return payWayMoney;
    }

    public void setPayWayMoney(Double payWayMoney) {
        this.payWayMoney = payWayMoney;
    }

    public Double getGetMoney() {
        return getMoney;
    }

    public void setGetMoney(Double getMoney) {
        this.getMoney = getMoney;
    }

    public Double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Double backMoney) {
        this.backMoney = backMoney;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getCreatorType() {
        return creatorType;
    }

    public void setCreatorType(String creatorType) {
        this.creatorType = creatorType;
    }

    public String getCancelTradedMark() {
        return cancelTradedMark;
    }

    public void setCancelTradedMark(String cancelTradedMark) {
        this.cancelTradedMark = cancelTradedMark;
    }

    public Integer getOrderAssessmentStar() {
        return orderAssessmentStar;
    }

    public void setOrderAssessmentStar(Integer orderAssessmentStar) {
        this.orderAssessmentStar = orderAssessmentStar;
    }

    public Integer getAutoDeduct() {
        return autoDeduct;
    }

    public void setAutoDeduct(Integer autoDeduct) {
        this.autoDeduct = autoDeduct;
    }

    public String getOtherSystemOrderNo() {
        return otherSystemOrderNo;
    }

    public void setOtherSystemOrderNo(String otherSystemOrderNo) {
        this.otherSystemOrderNo = otherSystemOrderNo;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Integer parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Double getPreAmount() {
        return preAmount;
    }

    public void setPreAmount(Double preAmount) {
        this.preAmount = preAmount;
    }

    public Integer getPayFrom() {
        return payFrom;
    }

    public void setPayFrom(Integer payFrom) {
        this.payFrom = payFrom;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarCheckId() {
        return carCheckId;
    }

    public void setCarCheckId(Integer carCheckId) {
        this.carCheckId = carCheckId;
    }

    public Integer getRework() {
        return rework;
    }

    public void setRework(Integer rework) {
        this.rework = rework;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getPreTransactionId() {
        return preTransactionId;
    }

    public void setPreTransactionId(String preTransactionId) {
        this.preTransactionId = preTransactionId;
    }

    public String getPreOutTradeNo() {
        return preOutTradeNo;
    }

    public void setPreOutTradeNo(String preOutTradeNo) {
        this.preOutTradeNo = preOutTradeNo;
    }

    public Long getDelayRepayId() {
        return delayRepayId;
    }

    public void setDelayRepayId(Long delayRepayId) {
        this.delayRepayId = delayRepayId;
    }

    public Short getOldOrder() {
        return oldOrder;
    }

    public void setOldOrder(Short oldOrder) {
        this.oldOrder = oldOrder;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getMemberDesc() {
        return memberDesc;
    }

    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc;
    }

    public Long getGetStaffId() {
        return getStaffId;
    }

    public void setGetStaffId(Long getStaffId) {
        this.getStaffId = getStaffId;
    }

    public Long getOutStaffId() {
        return outStaffId;
    }

    public void setOutStaffId(Long outStaffId) {
        this.outStaffId = outStaffId;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Long getRefundStaffId() {
        return refundStaffId;
    }

    public void setRefundStaffId(Long refundStaffId) {
        this.refundStaffId = refundStaffId;
    }
}