package com.epoint.order.service.impl;

import com.epoint.order.dao.EPOrderPrePayItemMapper;
import com.epoint.order.entity.OrderPrePayItem;
import com.epoint.order.service.IPrePayService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by chiang on 2017/4/17.
 */
@Component
public class PrePayService implements IPrePayService{

    @Resource
    private EPOrderPrePayItemMapper epOrderPrePayItemMapper;

    @Override
    public int prePay(Long orderId, List<OrderPrePayItem> prePayItemList) {
        int r = 0;
        if (prePayItemList != null) {
            for (OrderPrePayItem prePayItem:prePayItemList){
                prePayItem.setCreateTime(new Date());
                prePayItem.setOrderId(orderId.intValue());
                r = r + epOrderPrePayItemMapper.insert(prePayItem);
            }
        }
        return r;
    }

    @Override
    public List<OrderPrePayItem> selectPrePayItemList(Long orderId) {
        return epOrderPrePayItemMapper.selectByOrderId(orderId);
    }
}
