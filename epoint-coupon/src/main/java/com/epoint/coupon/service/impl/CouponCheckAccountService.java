package com.epoint.coupon.service.impl;

import com.epoint.coupon.dao.CouponCheckAccountMapper;
import com.epoint.coupon.dto.CouponCheckAccountDTO;
import com.epoint.coupon.service.ICouponCheckAccount;
import com.epoint.store.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by yyy on 2017/4/19.
 */
@Component
public class CouponCheckAccountService implements ICouponCheckAccount {

    @Autowired
    private CouponCheckAccountMapper couponCheckAccountMapper;

    @Override
    public int queryReceivableNumByPage(Map<String, Object> map) {
        return couponCheckAccountMapper.queryReceivableNumByPage(map);
    }

    @Override
    public List<CouponCheckAccountDTO> queryReceivableListByPage(Map<String, Object> map) {
        return couponCheckAccountMapper.queryReceivableListByPage(map);
    }

    @Override
    public int queryPayableNumByPage(Map<String, Object> map) {
        return couponCheckAccountMapper.queryPayableNumByPage(map);
    }

    @Override
    public List<CouponCheckAccountDTO> queryPayableListByPage(Map<String, Object> map) {
        return couponCheckAccountMapper.queryPayableListByPage(map);
    }

    @Override
    public List<Store> queryReceivableStoreList(Map<String, Object> map) {
        return couponCheckAccountMapper.queryReceivableStoreList(map);
    }

    @Override
    public List<Store> queryPayableStoreList(Map<String, Object> map) {
        return couponCheckAccountMapper.queryPayableStoreList(map);
    }

    @Override
    public List<CouponCheckAccountDTO> querySumReceivableCount(Map<String, Object> map) {
        return couponCheckAccountMapper.querySumReceivableCount(map);
    }

    @Override
    public List<CouponCheckAccountDTO> querySumPayableCount(Map<String, Object> map) {
        return couponCheckAccountMapper.querySumPayableCount(map);
    }
}
