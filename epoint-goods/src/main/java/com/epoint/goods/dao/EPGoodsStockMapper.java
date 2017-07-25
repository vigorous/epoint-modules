package com.epoint.goods.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.goods.entity.GoodsStock;

public interface EPGoodsStockMapper extends BaseMapper<GoodsStock> {
    /**
     * 根据条件修改库存量
     * 必填（goodsId, storeId, amount）
     *
     * @param goodsStock
     * @return
     */
    int updateAmountByCondition(GoodsStock goodsStock);
}