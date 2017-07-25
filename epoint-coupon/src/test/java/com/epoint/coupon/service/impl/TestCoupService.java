package com.epoint.coupon.service.impl;

import com.epoint.coupon.entity.MemberCoupon;
import com.epoint.coupon.service.ICouponService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import spring.test.BeanTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chiang on 2017/4/13.
 */
public class TestCoupService extends BeanTest{
    private final static Logger LOGGER = LogManager.getLogger(TestCoupService.class.getName());

    @Resource
    private ICouponService couponService;

    @Test
    public void  testSendCoupon(){
        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setCouponId(1L);
        couponService.sendCoupon(memberCoupon);
    }

    @Test
    public void testUsedCoupon(){
        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setCouponId(1L);
        couponService.usedCoupon(memberCoupon,100.00);
    }

    @Test
    public void testUseCoupon(){
        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setCouponId(1L);
        couponService.useCoupon(memberCoupon);
    }

    @Test
    public void testSelectMemberCouponByMemberId(){
        List<MemberCoupon> couponList = couponService.selectMemberCouponByMemberId(1L,1L);
        Assert.assertEquals(0,couponList.size());
    }
}
