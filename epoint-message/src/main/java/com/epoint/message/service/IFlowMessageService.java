package com.epoint.message.service;

import com.epoint.message.entity.SystemMessage;
import com.epoint.order.entity.OrderItem;

import java.util.List;

/**
 * @author xishengchun on 2017-05-27.
 * 业务流程上节点上的动作消息推送
 */
public interface IFlowMessageService {

    /**
     * 根据接车单,指派验车通知
     * @param systemMessage
     * @exception com.epoint.message.exception.MessageException
     * 调用该方法的时候,确认方法内是否要捕获异常
     */
    void noticeCheckCar(SystemMessage systemMessage);

    /**
     * 开单通知
     * @param systemMessage
     * @exception com.epoint.message.exception.MessageException
     */
    void noticeCreateOrder(SystemMessage systemMessage);

    /**
     * 派工通知
     * @param orderId
     * @exception com.epoint.message.exception.MessageException
     */
    void noticeDispatch(Long orderId);

    /**
     * 针对订单明细派工
     * @param orderId 订单ID
     * @param orderItem 订单明细
     * @exception com.epoint.message.exception.MessageException
     */
    void noticeDispatch(Long orderId, OrderItem orderItem);

    /**
     * 商品领料通知
     * @param orderId
     * @exception com.epoint.message.exception.MessageException
     */
    void noticePick(Long orderId);

    /**
     * 针对订单明细领料通知
     * @param orderId 订单ID
     * @param orderItem 订单明细
     * @exception com.epoint.message.exception.MessageException
     */
    void noticePick(Long orderId, OrderItem orderItem);

    /**
     * 收银通知
     * @param orderId
     * @exception com.epoint.message.exception.MessageException
     */
    void noticePay(Long orderId);

    /**
     * 质检通知
     * @param orderId
     * @param orderItemIdList
     * 质检的项id.erp_work_order_item.id
     * @exception com.epoint.message.exception.MessageException
     */
    void noticeInspector(Long orderId, List<Long> orderItemIdList);

    /*
        App专用
     */
    void noticeMessage(SystemMessage systemMessage);
    /*
        App专用
     */
    void noticePickMessage(Long orderId, OrderItem orderItem,String extras);
    /*
        App专用
     */
    void noticeDispatchMessage(Long orderId, OrderItem orderItem,String extras);

}
