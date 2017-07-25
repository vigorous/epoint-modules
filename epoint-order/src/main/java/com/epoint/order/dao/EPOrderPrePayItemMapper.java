package com.epoint.order.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.order.entity.OrderPrePayItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EPOrderPrePayItemMapper extends BaseMapper<OrderPrePayItem> {
    List<OrderPrePayItem> selectByOrderId(@Param("orderId") Long orderId);

}