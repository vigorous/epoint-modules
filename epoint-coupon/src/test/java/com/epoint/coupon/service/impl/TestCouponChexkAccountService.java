package com.epoint.coupon.service.impl;

import com.epoint.coupon.dto.CouponCheckAccountDTO;
import com.epoint.coupon.service.ICouponCheckAccount;
import com.epoint.store.entity.Store;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.test.BeanTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yyy on 2017/4/20.
 */
public class TestCouponChexkAccountService extends BeanTest {
    @Autowired
    private ICouponCheckAccount iCouponCheckAccount;
    @Test
    public void testQueryReceivableStoreList(){
        Map condition = new HashMap<>();
        condition.put("storeId",2786);
        List<Store> queryReceivableStoreList = iCouponCheckAccount.queryReceivableStoreList(condition);
        List<CouponCheckAccountDTO> couponCheckAccountDTOS = iCouponCheckAccount.queryReceivableListByPage(condition);
        int count = iCouponCheckAccount.queryReceivableNumByPage(condition);
        List<CouponCheckAccountDTO> couponCheckAccountDTOS1 = iCouponCheckAccount.querySumReceivableCount(condition);
        condition.put("storeId",2448);
        List<Store> queryPaybleStoreList = iCouponCheckAccount.queryPayableStoreList(condition);
        List<CouponCheckAccountDTO> couponCheckAccountDTOS2 = iCouponCheckAccount.queryPayableListByPage(condition);
        int count2 = iCouponCheckAccount.queryPayableNumByPage(condition);
        List<CouponCheckAccountDTO> couponCheckAccountDTOS3 = iCouponCheckAccount.querySumPayableCount(condition);
        System.out.println(queryReceivableStoreList);
    }
}
