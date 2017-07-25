package com.epoint.car.service;

import java.util.Map;

/**
 * package:com.epoint.car.service
 *
 * @Author smallc on 2017/5/23.
 */
public interface IEPCarService {
    /**
     * 查车品牌名称
     *
     * @param brandId
     * @param serialId
     * @param modelId
     * @return
     */
    Map<String,String> queryCarBrandName(Long brandId, Long serialId, Long modelId);

    /**
     * 查车品牌名称
     *
     * @param brandId
     * @param serialId
     * @return
     */
    Map<String,String> queryCarBrandName(Long brandId, Long serialId);

    /**
     * 查车品牌名称
     *
     * @param brandId
     * @return
     */
    String queryCarBrandName(Long brandId);
}
