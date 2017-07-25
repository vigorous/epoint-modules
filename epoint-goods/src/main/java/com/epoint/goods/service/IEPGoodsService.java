package com.epoint.goods.service;

/**
 * package:com.epoint.goods.service
 *
 * @Author smallc on 2017/6/5.
 */
public interface IEPGoodsService {

    /**
     * 根据商品名称减库存
     *
     * @param goodsId
     * 商品id
     * @param storeId
     * 门店id
     * @param amount
     * 扣减数量
     */
    boolean reduceStock(Long goodsId, Long storeId, Double amount);
}
