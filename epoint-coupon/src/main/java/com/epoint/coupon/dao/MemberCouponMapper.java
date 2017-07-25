package com.epoint.coupon.dao;

import com.epoint.coupon.dto.MyCoupon;
import com.epoint.coupon.entity.MemberCoupon;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MemberCouponMapper extends BaseMapper<MemberCoupon> {
    List<MemberCoupon> selectMemberCoupon(MemberCoupon memberCoupon);

    /**
     * 查询同一个券会员领取几张
     * @param couponId
     * @return
     */
    List<MemberCoupon> selectMemberCouponByCouponId(@Param("couponId") Long couponId,@Param("memberId") Long memberId);

    /**
     * 查询某门店在连锁体系下面的领取的所有券
     * @param memberId
     * @param storeId
     * @return
     */
    List<MyCoupon> selectMemberCouponByMemberId(@Param("memberId") Long memberId,@Param("storeId") Long storeId);

    /**
     * 查询该门店该券的领取量
     * @param storeId 门店ID
     * @param couponId 赠券ID
     * @return
     */
    Integer selectTotalReceiveNum(@Param("storeId") Long storeId,@Param("couponId") Long couponId);

    /**
     * 查询该门店该券的使用量
     * @param storeId
     * @param couponId
     * @return
     */
    Integer selectTotalUseNum(@Param("storeId") Long storeId,@Param("couponId") Long couponId);

    List<MyCoupon> queryListByPage(Map map);
    int queryNumByPage(Map map);
}