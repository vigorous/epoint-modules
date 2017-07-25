package com.epoint.member.service;

import com.epoint.member.entity.StoreCarLog;

/**
 * package:com.epoint.member.service
 *
 * @Author smallc on 2017/5/23.
 */
public interface IEPStoreCarService {
    StoreCarLog queryCarById(Long id);

    /**
     * 根据车牌号查车辆信息
     * @param storeId
     * @param memberId
     * @param carNo
     * @return StoreCarLog
     */
    StoreCarLog queryCarByCarNo(Long storeId,Long memberId,String carNo);
}
