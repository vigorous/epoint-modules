package com.epoint.coupon.dto;

import com.epoint.coupon.entity.MemberCoupon;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class MemberCouponDTO {
    private MemberCoupon memberCoupon;
    private List<StoreCouponDTO> storeCouponDTOList;

    public MemberCoupon getMemberCoupon() {
        return memberCoupon;
    }

    public void setMemberCoupon(MemberCoupon memberCoupon) {
        this.memberCoupon = memberCoupon;
    }

    public List<StoreCouponDTO> getStoreCouponDTOList() {
        return storeCouponDTOList;
    }

    public void setStoreCouponDTOList(List<StoreCouponDTO> storeCouponDTOList) {
        this.storeCouponDTOList = storeCouponDTOList;
    }
}
