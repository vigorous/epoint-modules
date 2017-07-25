package com.epoint.message.service.impl;

import com.epoint.message.entity.SystemMessage;
import com.epoint.message.enums.MessageConstant;
import com.epoint.message.service.IFlowMessageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

import java.util.Date;

/**
 * @author xishengchun on 2017-05-31.
 */
public class FlowMessageServiceTest extends BeanTest {

    @Autowired
    private IFlowMessageService flowMessageService;

    @Test
    public void testNoticeCheckCar() {
        SystemMessage systemMessage = new SystemMessage();
        systemMessage.setTitle("您有新的验车任务,请尽快处理");
        systemMessage.setType((short) MessageConstant.MessageType.CHECK_CAR.code);
        systemMessage.setStatus((short) MessageConstant.MessageStatus.UNREAD.code);
        systemMessage.setStaffId(15L);
        systemMessage.setMemberId(83770L);
        systemMessage.setCarNo("沪C31AM8");
        systemMessage.setDataId(21L);
        systemMessage.setStoreId(1L);
        Date today = new Date();
        systemMessage.setCreateTime(today);
        systemMessage.setUpdateTime(today);
        flowMessageService.noticeCheckCar(systemMessage);
    }

    @Test
    public void testNoticePay() {
        Long orderId = 491325L;
        flowMessageService.noticePay(orderId);
    }

    public void testNoticeInspector() {

    }

}
