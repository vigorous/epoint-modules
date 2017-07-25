package com.epoint.order.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.order.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EPOrderMapper extends BaseMapper<Order> {
    /**
     * 查询门店所有未支付的订单数
     *
     * @param storeId
     * @return Integer
     */
    Integer queryNonPayOrder(@Param("storeId") Long storeId);

    /**
     * 根据门店ID、订单状态查询订单
     *
     * @param storeId 门店ID
     * @param status  状态
     * @return List<Order>
     */
    List<Order> queryOrderByStatus(@Param("storeId") Long storeId, @Param("status") String status);

    /**
     * 根据条件查询订单
     *
     * @param storeId    门店ID
     * @param status     状态
     * @param workAreaId 工位ID
     * @return List<Order>
     */
    List<Order> queryOrderByCondition(@Param("storeId") Long storeId, @Param("status") String status, @Param("workAreaId") Long workAreaId);
}