package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_coupon_share_result
 */
public class CouponShareResult extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 赠券ID
     */
    private Long couponId;

    /**
     * 注册会员ID
     */
    private Long regMemberId;

    /**
     * 手机号
     */
    private String regMobile;

    /**
     * 分享人ID
     */
    private Long shareMemberId;

    /**
     * 分享人手机号
     */
    private String shareMobile;

    /**
     * 状态:0-有效，1-无效
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

    public Long getRegMemberId() {
        return regMemberId;
    }

    public void setRegMemberId(Long regMemberId) {
        this.regMemberId = regMemberId;
    }

    public String getRegMobile() {
        return regMobile;
    }

    public void setRegMobile(String regMobile) {
        this.regMobile = regMobile;
    }

    public Long getShareMemberId() {
        return shareMemberId;
    }

    public void setShareMemberId(Long shareMemberId) {
        this.shareMemberId = shareMemberId;
    }

    public String getShareMobile() {
        return shareMobile;
    }

    public void setShareMobile(String shareMobile) {
        this.shareMobile = shareMobile;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}