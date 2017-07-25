package com.epoint.store.service.impl;

import com.epoint.store.dao.EPStoreMapper;
import com.epoint.store.entity.Store;
import com.epoint.store.service.IEPStoreService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/6/1.
 */
@Component
public class EPStoreService implements IEPStoreService{
    @Resource
    private EPStoreMapper epStoreMapper;

    @Override
    public Store queryById(Long id) {
        return epStoreMapper.selectById(id);
    }
}
