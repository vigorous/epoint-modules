package com.epoint.coupon.dto;

import com.epoint.coupon.entity.StoreCoupon;

/**
 * package:com.epoint.coupon.dto
 *
 * @Author smallc on 2017/4/14.
 */
public class StoreCouponDTO extends StoreCoupon {

    private String storeName;//门店名称

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
