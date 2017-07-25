package com.epoint.order.service;

import com.epoint.order.entity.OrderPrePayItem;

import java.util.List;

/**
 * Created by chiang on 2017/4/17.
 */
public interface IPrePayService {
    int prePay(Long orderId,List<OrderPrePayItem> prePayItemList);

    List<OrderPrePayItem> selectPrePayItemList(Long orderId);
}
