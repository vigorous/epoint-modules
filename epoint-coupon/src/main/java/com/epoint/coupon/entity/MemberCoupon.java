package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 表名:erp_coupon_member
 */
public class MemberCoupon extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 微信ID
     */
    private Long wxUserId;

    /**
     * 微信昵称
     */
    private String wxUserName;

    /**
     * 赠券ID
     */
    private Long couponId;

    /**
     * 赠券名称
     */
    private String couponName;

    /**
     * 赠券创建门店ID
     */
    private Long couponStoreId;

    /**
     * 领取门店ID
     */
    private Long receiveStoreId;

    private Short receiveType;//领取类型 1:注册领取;2:分享领取;3:ERP发送

    /**
     * 赠券类型:1-现金
     */
    private Short couponType;

    /**
     * 赠券金额
     */
    private Double couponMoney;

    /**
     * 赠券内容
     */
    private String couponContent;

    /**
     * 领取时间
     */
    private Date receiveTime;

    /**
     * 使用门店ID
     */
    private Long useStoreId;

    /**
     * 使用时间
     */
    private Date useTime;

    /**
     * 有效开始时间
     */
    private Date startTime;

    /**
     * 有效结束时间
     */
    private Date endTime;

    /**
     * 状态：0-未使用，1-已使用
     */
    private Short status;

    /**
     * 分享任务ID
     */
    private Long taskId;
    /**
     * 分享数量
     */
    private Integer shareNum;

    private Date createTime;

    private Date updateTime;

    /**
     * 关联的项目或商品ID,现金券该字段为NULL
     */
    private Long itemId;


    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Long wxUserId) {
        this.wxUserId = wxUserId;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getCouponStoreId() {
        return couponStoreId;
    }

    public void setCouponStoreId(Long couponStoreId) {
        this.couponStoreId = couponStoreId;
    }

    public Long getReceiveStoreId() {
        return receiveStoreId;
    }

    public void setReceiveStoreId(Long receiveStoreId) {
        this.receiveStoreId = receiveStoreId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Long getUseStoreId() {
        return useStoreId;
    }

    public void setUseStoreId(Long useStoreId) {
        this.useStoreId = useStoreId;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getStartTime() {
        return startTime;
    }
    public String getStartTimeCn(){
        if (startTime != null) {
            return DateFormatUtils.ISO_DATE_FORMAT.format(startTime);
        }else {
            return null;
        }
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public String getEndTimeCn(){
        if (endTime != null) {
            return DateFormatUtils.ISO_DATE_FORMAT.format(endTime);
        }else {
            return null;
        }
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Short getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(Short receiveType) {
        this.receiveType = receiveType;
    }

    public Double getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Short getCouponType() {
        return couponType;
    }

    public void setCouponType(Short couponType) {
        this.couponType = couponType;
    }

    public String getCouponContent() {
        return couponContent;
    }

    public void setCouponContent(String couponContent) {
        this.couponContent = couponContent;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}