package com.epoint.member.service.impl;

import com.epoint.member.dao.EPStoreCarLogMapper;
import com.epoint.member.entity.StoreCarLog;
import com.epoint.member.service.IEPStoreCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * package:com.epoint.member.service.impl
 *
 * @Author smallc on 2017/5/23.
 */
@Service
public class EPStoreCarService implements IEPStoreCarService {

    @Resource
    private EPStoreCarLogMapper epStoreCarLogMapper;

    @Override
    public StoreCarLog queryCarById(Long id) {
        return epStoreCarLogMapper.selectById(id);
    }

    @Override
    public StoreCarLog queryCarByCarNo(Long storeId, Long memberId, String carNo) {
        StoreCarLog queryCondition = new StoreCarLog();
        queryCondition.setStoreId(storeId);
        queryCondition.setMemberId(memberId);
        queryCondition.setCarNo(carNo);
        List<StoreCarLog> carLogList = epStoreCarLogMapper.selectByCondition(queryCondition);
        return carLogList != null
                && !carLogList.isEmpty()?carLogList.get(0):null;
    }
}
