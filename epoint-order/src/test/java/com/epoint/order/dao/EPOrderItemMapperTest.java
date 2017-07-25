package com.epoint.order.dao;

import com.epoint.order.entity.OrderItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import spring.test.BeanTest;

/**
 * @author xishengchun on 2017-07-04.
 */
public class EPOrderItemMapperTest extends BeanTest {

    @Autowired
    private EPOrderItemMapper epOrderItemMapper;

    @Test
    @Rollback(false)
    public void testUpdateById() {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsOutStaffId(100L);
        orderItem.setId(830972L);
        epOrderItemMapper.updateById(orderItem);
    }
}
