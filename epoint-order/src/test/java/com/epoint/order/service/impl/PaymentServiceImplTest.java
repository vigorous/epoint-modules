package com.epoint.order.service.impl;

import com.epoint.order.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

/**
 * @author xishengchun on 2017-04-07.
 */
public class PaymentServiceImplTest extends BeanTest {

    private final static Logger LOGGER = LogManager.getLogger(PaymentServiceImplTest.class.getName());


//    @Autowired
//    private EPOrderMapper orderMapper;

    @Test
    public void testPay() {
//        Order order = orderMapper.selectById(202894L);
//        LOGGER.debug("********************order:{}", order);
    }

}
