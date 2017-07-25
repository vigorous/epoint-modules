package com.epoint.goods.service.impl;

import com.epoint.goods.dao.EPGoodsStockMapper;
import com.epoint.goods.entity.GoodsStock;
import com.epoint.goods.exception.GoodsException;
import com.epoint.goods.service.IEPGoodsService;
import com.epoint.goods.service.IEPWareHouseStockService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * package:com.epoint.goods.service.impl
 *
 * @Author smallc on 2017/6/5.
 */
@Service
public class EPGoodsService implements IEPGoodsService {

    private Logger logger = LogManager.getLogger(EPGoodsService.class);

    @Autowired
    private EPGoodsStockMapper epGoodsStockMapper;

    @Autowired
    private IEPWareHouseStockService epWareHouseStockService;


    @Override
    public boolean reduceStock(Long goodsId, Long storeId, Double amount) {
        /* 修改商品库存 */
        GoodsStock goodsStock = new GoodsStock();
        goodsStock.setGoodsId(goodsId);
        goodsStock.setStoreId(storeId);
        goodsStock.setAmount(0 - amount);

        int r = epGoodsStockMapper.updateAmountByCondition(goodsStock);

        if (r < 1) {
            logger.debug("goodsId:{}", goodsId);
            throw new GoodsException("商品库存不足");
        }
            /* 减仓库库存 */
        boolean flag = epWareHouseStockService.reduceWareHouseStock(goodsId, storeId, null, amount);
        return flag;
    }

}
