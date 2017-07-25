package com.epoint.role.dao.erp;

import com.epoint.role.erp.dto.ErpRoleMenuDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

import java.util.List;
import java.util.Map;

/**
 * Created by yyy on 2017-05-23.
 */
public class TestErpRoleMenuService extends BeanTest{
    @Autowired
    private ErpRoleMapper erpRoleMapper;

    @Test
    public void testQueryMenuByRoleId(){
        List<Long> erpRoleMenuDTOList = erpRoleMapper.queryMenuByRoleId(1381L);
        System.out.println(erpRoleMenuDTOList.size());
        Assert.assertNotNull(erpRoleMenuDTOList);
    }
}
