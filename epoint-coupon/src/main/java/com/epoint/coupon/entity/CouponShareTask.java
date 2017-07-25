package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_coupon_share_task
 */
public class CouponShareTask extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 赠券ID
     */
    private Long couponId;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 分享数量
     */
    private Integer shareNum;

    /**
     * 状态：0-未完成，1-完成，2-已领取
     */
    private Short status;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}