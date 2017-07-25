package com.epoint.member.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.member.entity.StoreCarLog;

import java.util.List;

public interface EPStoreCarLogMapper extends BaseMapper<StoreCarLog> {
    /**
     * 根据条件查询门店会员车辆信息
     * （门店ID，会员ID，车牌号）必传
     *
     * @param storeCarLog
     * @return
     */
    List<StoreCarLog> selectByCondition(StoreCarLog storeCarLog);
}