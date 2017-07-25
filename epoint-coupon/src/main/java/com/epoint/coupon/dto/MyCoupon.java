package com.epoint.coupon.dto;

import com.epoint.coupon.entity.MemberCoupon;

import java.util.List;

/**
 * Created by chiang on 2017/4/14.
 */
public class MyCoupon extends MemberCoupon{
    private String storeName;//创建门店

    private String receiveStoreName;//领取门店

    private String useStoreName; //使用门店

    private Integer amount;

    private String memberName;

    private String userTimes;

    private String userStoreNames;

    private List<StoreCouponDTO> storeCouponDTOList;

    //适用门店总数
    private Integer totalStoreNum;

    private String endTimeNum;

    private String couponStatus;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getReceiveStoreName() {
        return receiveStoreName;
    }

    public void setReceiveStoreName(String receiveStoreName) {
        this.receiveStoreName = receiveStoreName;
    }

    public String getUseStoreName() {
        return useStoreName;
    }

    public void setUseStoreName(String useStoreName) {
        this.useStoreName = useStoreName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getUserTimes() {
        return userTimes;
    }

    public void setUserTimes(String userTimes) {
        this.userTimes = userTimes;
    }

    public String getUserStoreNames() {
        return userStoreNames;
    }

    public void setUserStoreNames(String userStoreNames) {
        this.userStoreNames = userStoreNames;
    }

    public List<StoreCouponDTO> getStoreCouponDTOList() {
        return storeCouponDTOList;
    }

    public void setStoreCouponDTOList(List<StoreCouponDTO> storeCouponDTOList) {
        this.storeCouponDTOList = storeCouponDTOList;
    }

    public Integer getTotalStoreNum() {
        return totalStoreNum;
    }

    public void setTotalStoreNum(Integer totalStoreNum) {
        this.totalStoreNum = totalStoreNum;
    }

    public String getEndTimeNum() {
        return endTimeNum;
    }

    public void setEndTimeNum(String endTimeNum) {
        this.endTimeNum = endTimeNum;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }
}
