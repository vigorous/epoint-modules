package com.epoint.order.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.order.dto.OrderItemDTO;
import com.epoint.order.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EPOrderItemMapper extends BaseMapper<OrderItem> {
    /**
     * 根据订单ID查询订单明细信息
     * @param orderId 订单ID
     * @return List<OrderItem>
     */
    List<OrderItem> queryOrderItemByOrderId(@Param("orderId") Long orderId);

    /**
     * 根据订单ID查询商品明细
     * @param orderId 订单ID
     * @return List<OrderItemDTO>
     */
    List<OrderItemDTO> queryOrderItemForAutoWork(@Param("orderId") Long orderId);

    /**
     * 根据订单ID查询项目明细
     * @param orderId 订单ID
     * @return List<OrderItemDTO>
     */
    List<OrderItemDTO> queryOrderItemForGoods(@Param("orderId") Long orderId);
}