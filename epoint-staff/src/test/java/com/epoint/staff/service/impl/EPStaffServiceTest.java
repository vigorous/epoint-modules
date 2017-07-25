package com.epoint.staff.service.impl;

import com.epoint.staff.dao.EPStaffGroupMapper;
import com.epoint.staff.dao.EPStaffMapper;
import com.epoint.staff.dto.StaffDTO;
import com.epoint.staff.entity.StaffGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import spring.test.BeanTest;

/**
 * package:com.epoint.staff.service.impl
 *
 * @Author smallc on 2017/5/31.
 */
public class EPStaffServiceTest extends BeanTest {
    private final static Logger LOGGER = LogManager.getLogger(EPStaffServiceTest.class.getName());

    @Autowired
    private EPStaffGroupMapper epStaffGroupMapper;

    @Autowired
    private EPStaffMapper epStaffMapper;

    @Test
    public void test() {
        StaffGroup staffGroup = epStaffGroupMapper.queryOneStaffGroup(70L);
        System.out.println(staffGroup.toString());
    }

    @Test
    public void queryStaffByCondition(){
        StaffDTO staffDTO = epStaffMapper.queryStaffByCondition(15L,1L);
        System.out.println(staffDTO);
    }

}