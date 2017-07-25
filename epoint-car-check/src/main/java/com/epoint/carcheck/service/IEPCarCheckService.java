package com.epoint.carcheck.service;

import com.epoint.carcheck.entity.EPCarCheck;

/**
 * Created by chiang on 2017/5/31.
 */
public interface IEPCarCheckService {
    /**
     * 查会员最新一次验车记录
     * @param memberId
     * @return
     */
    EPCarCheck getNewestEPCarCheck(Long memberId);

    /**
     * 根据验车ID,查验车记录
     * @param carCheckId
     * @return
     */
    EPCarCheck getEPCarCheck(Long carCheckId);
}
