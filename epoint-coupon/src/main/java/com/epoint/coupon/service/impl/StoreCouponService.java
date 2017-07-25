package com.epoint.coupon.service.impl;

import com.epoint.coupon.dao.StoreCouponMapper;
import com.epoint.coupon.dto.StoreCouponDTO;
import com.epoint.coupon.service.IStoreCouponService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * package:com.epoint.coupon.service.impl
 *
 * @Author smallc on 2017/4/17.
 */
@Component
public class StoreCouponService implements IStoreCouponService {

    private final static Logger LOGGER = LogManager.getLogger(StoreCouponService.class.getName());

    @Resource
    private StoreCouponMapper storeCouponMapper;

    @Override
    public List<StoreCouponDTO> queryApplyStoreByCouponId(Long couponId) {
        return storeCouponMapper.queryApplyStoreByCouponId(couponId);
    }
}
