package com.epoint.order.service;

import com.epoint.order.dto.OrderItemDTO;
import com.epoint.order.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xishengchun on 2017-06-05.
 */
public interface IEPOrderService {

    /**
     * 查询订单明细。
     * 包括领料人,领料组
     *
     * @param orderId
     * @return
     */
    List<OrderItemDTO> queryOrderItemForGoods(Long orderId);

    /**
     * 根据订单ID查询商品明细
     *
     * @param orderId 订单ID
     * @return List<OrderItemDTO>
     */
    List<OrderItemDTO> queryOrderItemForAutoWork(@Param("orderId") Long orderId);

    /**
     * 校验该订单所有的明细是否都已派工
     *
     * @param orderId 订单ID
     * @return boolean
     */
    boolean validOrderAllDetailAssign(Long orderId);

    /**
     * 校验该订单中的商品是否都已派发领料
     *
     * @param orderId 订单ID
     * @return boolean
     */
    boolean validOrderGoodsPick(Long orderId);

    /**
     * 指派质检
     *
     * @param orderId       订单ID
     * @param orderItems 订单项目明细
     */
    void assignCheck(Long orderId, List<OrderItem> orderItems);


    /**
     * 扣减库存
     * @param goodsItemDTOList
     * 订单明细中的商品项
     * @param goodsOutStaffId
     * 出库人
     */
    void reduceGoodsStock(List<OrderItem> goodsItemDTOList, Long goodsOutStaffId);

}
