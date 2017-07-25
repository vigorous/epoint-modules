package com.epoint.service;

import com.epoint.reception.dto.ReceptionDetailDTO;
import com.epoint.reception.service.IReceptionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/5/25.
 */
public class ReceptionServiceTest extends BeanTest {
    @Autowired
    private IReceptionService receptionService;

    @Test
    public void run(){
        ReceptionDetailDTO receptionDetail = receptionService.getReceptionDetail(1L);
        logger.info("receptionDetail: {}", receptionDetail);
    }
}
