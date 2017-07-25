package com.epoint.carcheck.service.impl;

import com.epoint.carcheck.dao.EPCarCheckMapper;
import com.epoint.carcheck.entity.EPCarCheck;
import com.epoint.carcheck.service.IEPCarCheckService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/5/31.
 */
@Component
public class EPCarCheckService implements IEPCarCheckService{

    @Resource
    private EPCarCheckMapper epCarCheckMapper;

    @Override
    public EPCarCheck getNewestEPCarCheck(Long memberId) {
        return epCarCheckMapper.selectNoOrderCarCheck(memberId);
    }

    @Override
    public EPCarCheck getEPCarCheck(Long carCheckId) {
        return epCarCheckMapper.selectById(carCheckId.intValue());
    }
}
