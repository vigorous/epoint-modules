package com.epoint.book.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wx_book_info
 */
public class BookInfo extends BaseEntity {
    private Long id;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 预约日期。 格式:2017-05-17
     */
    private String bookDate;

    /**
     * 预约的几点 如9
     */
    private String bookHour;

    /**
     * 车主ID
     */
    private Long memberId;

    /**
     * 车主姓名
     */
    private String memberName;

    /**
     * 是否会员;是或否
     */
    private String isMember;

    /**
     * 专属客服
     */
    private String customerManager;

    /**
     * 车主手机号
     */
    private String mobile;

    /**
     * 车主车牌号
     */
    private String carNo;

    /**
     * 偏好
     */
    private String tags;

    /**
     * 预约的项目 “|”分开 
     */
    private String serviceItemList;

    /**
     * 预约说明--车主填写
     */
    private String memberRemark;

    /**
     * 反馈说明--门店填写
     */
    private String storeRemark;

    /**
     * 预约入口. 1:首页(我的)预约;2:保养手册预约;3:项目预约;
     */
    private Integer bookType;

    /**
     * 0:预约失败;1:预约成功;2:取消预约;3:已到店
     */
    private Integer status;

    /**
     * 1:已读;0:未读
     */
    private Integer readStatus;
    /**
     * 接车ID
     */
    private Long receptionId;
    /**
     * 验车ID
     */
    private Long carCheckId;

    /**
     * 1:已发送;
     * 0:未发送
     */
    private Integer sendSms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookHour() {
        return bookHour;
    }

    public void setBookHour(String bookHour) {
        this.bookHour = bookHour;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getServiceItemList() {
        return serviceItemList;
    }

    public void setServiceItemList(String serviceItemList) {
        this.serviceItemList = serviceItemList;
    }

    public String getMemberRemark() {
        return memberRemark;
    }

    public void setMemberRemark(String memberRemark) {
        this.memberRemark = memberRemark;
    }

    public String getStoreRemark() {
        return storeRemark;
    }

    public void setStoreRemark(String storeRemark) {
        this.storeRemark = storeRemark;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Long getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(Long receptionId) {
        this.receptionId = receptionId;
    }

    public Long getCarCheckId() {
        return carCheckId;
    }

    public void setCarCheckId(Long carCheckId) {
        this.carCheckId = carCheckId;
    }

    public Integer getSendSms() {
        return sendSms;
    }

    public void setSendSms(Integer sendSms) {
        this.sendSms = sendSms;
    }
}