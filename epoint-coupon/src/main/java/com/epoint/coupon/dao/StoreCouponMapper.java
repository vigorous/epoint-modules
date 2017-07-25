package com.epoint.coupon.dao;

import com.epoint.coupon.dto.StoreCouponDTO;
import com.epoint.coupon.entity.StoreCoupon;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StoreCouponMapper extends BaseMapper<StoreCoupon> {
    /**
     * 根据赠券ID查询开启的适用门店
     * @param couponId 赠券ID
     * @return 该券所有的适用门店
     */
    List<StoreCouponDTO> queryApplyStoreByCouponId(@Param("couponId") Long couponId);
    /**
     * 根据赠券ID查询所有的适用门店
     * @param couponId 赠券ID
     * @return 该券所有的适用门店
     */
    List<StoreCouponDTO> queryAllApplyStoreByCouponId(@Param("couponId") Long couponId);

    /**
     * 查询优惠券的状态
     * @param couponId
     * @param storeId
     * @return
     */
    StoreCoupon selectByStoreIdAndCouponId(@Param("couponId")Long couponId,@Param("storeId")Long storeId);

    /**
     * 根据赠券ID、门店ID修改状态
     * @param storeCoupon
     * @return
     */
    int updateByCouponIdAndStoreId(StoreCoupon storeCoupon);

    /**
     * 查询适用门店总数量
     * @param couponId 赠券ID
     * @return
     */
    int selectApplyStoreNumByCouponId(@Param("couponId")Long couponId);

    /**
     * 查询到期的优惠券
     * @param map
     * @return
     */
    List<StoreCoupon> selectExpiredCoupon(Map map);

    /**
     * 修改领取量
     * @param couponId 赠券ID
     * @param storeId 门店ID
     * @return int
     */
    int updateReceiveNum(@Param("couponId")Long couponId,@Param("storeId")Long storeId,@Param("increment") int increment);

    /**
     * 更新使用量和金额
     * @param storeCoupon
     * @return
     */
    int updateUseNumAndOrderAmt(StoreCoupon storeCoupon);
}