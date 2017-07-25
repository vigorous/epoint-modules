package com.epoint.coupon.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_coupon_share
 */
public class CouponShare extends BaseEntity {
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
     * 赠券ID
     */
    private Long couponId;

    /**
     * 分享链接地址
     */
    private String sharePageUrl;

    /**
     * 分享主题
     */
    private String shareTitle;

    //从哪个门店分享的
    private Long shareStoreId;

    /**
     * 状态：0-未分享成功，1-分享成功
     */
    private Short status;

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

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getSharePageUrl() {
        return sharePageUrl;
    }

    public void setSharePageUrl(String sharePageUrl) {
        this.sharePageUrl = sharePageUrl;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public Long getShareStoreId() {
        return shareStoreId;
    }

    public void setShareStoreId(Long shareStoreId) {
        this.shareStoreId = shareStoreId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}