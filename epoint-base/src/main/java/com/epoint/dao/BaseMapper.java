package com.epoint.dao;

import com.epoint.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by chiang on 2017/4/7.
 */
public interface BaseMapper<E extends BaseEntity> extends Mapper {

    int deleteById(Serializable id);

    int insert(E record);

    E selectById(Serializable id);

    int updateById(E record);

}
