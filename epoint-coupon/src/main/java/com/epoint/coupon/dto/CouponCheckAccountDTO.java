package com.epoint.coupon.dto;

/**
 * Created by yyy on 2017/4/19.
 */
public class CouponCheckAccountDTO {
    //订单号
    private String orderNo;
    //优惠券名称
    private String couponName;
    //优惠券面值
    private Double couponMoney;
    //客户名称
    private String memberName;
    //微信昵称
    private String weiXinUserName;
    //客户手机号码
    private String memberMobile;
    //领取门店名称
    private String receiveStoreName;
    //使用门店名称
    private String useStoreName;
    //领取门店ID
    private Long receiveStoreId;
    //使用门店ID
    private Long useStoreId;
    //支付金额（订单实际金额）
    private Double payMoney;

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Double getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Double couponMoney) {
        this.couponMoney = couponMoney;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getWeiXinUserName() {
        return weiXinUserName;
    }

    public void setWeiXinUserName(String weiXinUserName) {
        this.weiXinUserName = weiXinUserName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
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

    public Long getReceiveStoreId() {
        return receiveStoreId;
    }

    public void setReceiveStoreId(Long receiveStoreId) {
        this.receiveStoreId = receiveStoreId;
    }

    public Long getUseStoreId() {
        return useStoreId;
    }

    public void setUseStoreId(Long useStoreId) {
        this.useStoreId = useStoreId;
    }
}
