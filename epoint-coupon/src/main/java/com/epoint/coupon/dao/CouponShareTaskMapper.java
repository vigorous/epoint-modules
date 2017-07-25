package com.epoint.coupon.dao;

import com.epoint.coupon.entity.CouponShareTask;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CouponShareTaskMapper extends BaseMapper<CouponShareTask> {

    /**
     * 查询分享数据
     * @param couponId
     * @return
     */
    CouponShareTask selectByCouponId(@Param("couponId") Long couponId,@Param("memberId") Long memberId);

    /**
     * 保存分享次数
     * @param task
     * @return
     */
    int incrementShareNum(CouponShareTask task);
}