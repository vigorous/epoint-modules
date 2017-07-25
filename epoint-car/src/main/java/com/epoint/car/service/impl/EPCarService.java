package com.epoint.car.service.impl;

import com.epoint.car.dao.EPCarBrandMapper;
import com.epoint.car.dao.EPCarModelMapper;
import com.epoint.car.dao.EPCarSeriesMapper;
import com.epoint.car.entity.CarBrand;
import com.epoint.car.entity.CarModel;
import com.epoint.car.entity.CarSeries;
import com.epoint.car.service.IEPCarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * package:com.epoint.car.service.impl
 *
 * @Author smallc on 2017/5/23.
 */
@Service
public class EPCarService implements IEPCarService {
    @Resource
    private EPCarBrandMapper epCarBrandMapper;

    @Resource
    private EPCarSeriesMapper epCarSeriesMapper;

    @Resource
    private EPCarModelMapper epCarModelMapper;

    @Override
    public Map<String,String> queryCarBrandName(Long brandId, Long serialId, Long modelId) {
        Map<String,String> resultMap = new HashMap<>();
        CarModel model = epCarModelMapper.selectById(modelId);
        if (model != null){
            resultMap.put("modelName",model.getName());
        } else {
            resultMap.put("modelName",StringUtils.EMPTY);
        }
        resultMap.putAll(queryCarBrandName(brandId,serialId));
        return resultMap;
    }

    @Override
    public Map<String, String> queryCarBrandName(Long brandId, Long serialId) {
        Map<String,String> resultMap = new HashMap<>();
        CarSeries series = epCarSeriesMapper.selectById(serialId);
        if (series != null){
            resultMap.put("serialName",series.getName());
        } else {
            resultMap.put("serialName",StringUtils.EMPTY);
        }
        resultMap.put("brandName",queryCarBrandName(brandId));

        return resultMap;
    }

    @Override
    public String queryCarBrandName(Long brandId) {
        CarBrand brand = epCarBrandMapper.selectById(brandId);
        if (brand == null){
            return StringUtils.EMPTY;
        }
        return  brand.getName();
    }
}
