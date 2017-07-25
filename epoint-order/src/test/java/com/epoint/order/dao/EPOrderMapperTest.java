package com.epoint.order.dao;

import com.epoint.order.dto.OrderItemDTO;
import com.epoint.order.entity.Order;
import com.epoint.order.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

import java.util.List;

/**
 * package:com.epoint.order.dao
 *
 * @Author smallc on 2017/5/31.
 */
public class EPOrderMapperTest extends BeanTest {
    private final static Logger LOGGER = LogManager.getLogger(EPOrderMapperTest.class.getName());

    @Autowired
    private EPOrderItemMapper epOrderItemMapper;

    @Autowired
    private EPOrderMapper epOrderMapper;

    @Test
    public void queryOrderItemByOrderId() {
        List<OrderItem> orderItemList = epOrderItemMapper.queryOrderItemByOrderId(491372L);
        System.out.println(orderItemList.size());
    }

    @Test
    public void queryOrderItemForAutoWork() {
        List<OrderItemDTO> orderItemDTOS = epOrderItemMapper.queryOrderItemForAutoWork(491372L);
        System.out.println(orderItemDTOS.toString());
    }

    @Test
    public void queryOrderItemForGoods() {
        List<OrderItemDTO> orderItemDTOS = epOrderItemMapper.queryOrderItemForGoods(491372L);
        System.out.println(orderItemDTOS.toString());
    }

    @Test
    public void queryNonPayOrder() {
        Long storeId = 1L;
        int count = epOrderMapper.queryNonPayOrder(storeId);
        System.out.println(count);
    }

    @Test
    public void queryOrderByCondition() {
        Long storeId = 1L;
        List<Order> list = epOrderMapper.queryOrderByCondition(storeId,"1",2795L);
        System.out.println(list);
    }
}