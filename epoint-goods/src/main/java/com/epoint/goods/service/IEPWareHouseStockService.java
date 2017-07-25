package com.epoint.goods.service;

/**
 * package:com.epoint.goods.service
 *
 * @Author smallc on 2017/6/5.
 */
public interface IEPWareHouseStockService {
    /**
     * 减仓库库存
     *
     * @param goodsId     商品ID
     * @param storeId     门店ID
     * @param warehouseId 仓库ID
     * @param outAmount   出库数量
     * @return boolean
     * @Exception GoodsException
     */
    boolean reduceWareHouseStock(Long goodsId, Long storeId, Long warehouseId, double outAmount);
}
