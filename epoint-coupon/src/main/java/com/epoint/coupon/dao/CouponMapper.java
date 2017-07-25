package com.epoint.coupon.dao;

import com.epoint.coupon.dto.CouponDTO;
import com.epoint.coupon.entity.Coupon;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CouponMapper extends BaseMapper<Coupon> {
    //增量更新
    int updateReceiveNum(@Param("id") Long id, @Param("increment") int increment);

    //增量更新(更新使用量和订单金额)
    int updateUseNumAndOrderAmt(Coupon coupon);

    List<Coupon> selectCoupon(Coupon coupon);
    /**
     * 分页查询赠券
     * @param map
     * @return
     */
    List<CouponDTO> queryListByPage(Map map);
    /**
     * 查询赠券数量
     * @param map
     * @return
     */
    Integer queryNumByPage(Map map);

    /**
     * 查询门店的自动注册规则数
     * @param storeId 门店ID
     * @return Integer
     */
    Integer selectRegAutoNum(@Param("storeId") Long storeId);

    /**
     * 分页查询赠券数据统计
     * @param map
     * @return
     */
    List<CouponDTO> queryStatisticsListByPage(Map map);
    /**
     * 查询赠券数据统计数量
     * @param map
     * @return
     */
    Integer queryStatisticsNumByPage(Map map);
}