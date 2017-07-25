package com.epoint.coupon.service;

import com.epoint.coupon.dto.StoreCouponDTO;

import java.util.List;

/**
 * package:com.epoint.coupon.service
 *
 * @Author smallc on 2017/4/17.
 */
public interface IStoreCouponService {
    /**
     * 根据赠券ID查询适用门店
     * @param couponId 赠券ID
     * @return 该券所有的适用门店
     */
    List<StoreCouponDTO> queryApplyStoreByCouponId(Long couponId);
}
