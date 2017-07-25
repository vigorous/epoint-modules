package com.epoint.goods.service.impl;

import com.epoint.goods.dao.EPWareHouseStockMapper;
import com.epoint.goods.entity.WareHouseStock;
import com.epoint.goods.exception.GoodsException;
import com.epoint.goods.service.IEPWareHouseStockService;
import com.rd.erp.util.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * package:com.epoint.goods.service.impl
 *
 * @Author smallc on 2017/6/5.
 */
@Service
public class EPWareHouseStockService implements IEPWareHouseStockService {

    private Logger logger = LogManager.getLogger(EPWareHouseStockService.class);

    @Autowired
    private EPWareHouseStockMapper epWareHouseStockMapper;

    @Override
    @Transactional
    public boolean reduceWareHouseStock(Long goodsId, Long storeId, Long warehouseId, double outAmount) {
        if (goodsId == null || storeId == null || outAmount == 0) {
            throw new GoodsException("参数异常");
        }

        BigDecimal bigOutAmount = new BigDecimal(String.valueOf(outAmount)); // 需要扣除的数量
        List<WareHouseStock> wareHouseStocks = epWareHouseStockMapper.queryWarehouseStockByCondition(goodsId, storeId, warehouseId);

        if (CollectionUtils.isEmpty(wareHouseStocks)) {
            logger.error("仓库中商品库存不存在, 考虑到旧数据可能没有仓库库存则忽略该错误 goodsId {} storeId {}", goodsId, storeId);
            return true;
        }

        // 所有仓库中的数量相加
        BigDecimal stockTotalAmount = new BigDecimal("0");
        for (WareHouseStock wareHouseStock : wareHouseStocks) {
            stockTotalAmount = NumberUtils.addition2(stockTotalAmount.doubleValue(), wareHouseStock.getAmount());
        }

        if (stockTotalAmount.doubleValue() < bigOutAmount.doubleValue()) {
            logger.error("仓库中商品库存不存在, 考虑到旧数据可能仓库库存小于出库的数量 goodsId {} storeId {} wareHouseId {} outAmount {} ",
                    goodsId, storeId, warehouseId, outAmount);
            return true;
        }

        // 扣除仓库中的库存数量
        for (WareHouseStock wareHouseStock : wareHouseStocks) {
            double balanceAmount = NumberUtils.toDouble(wareHouseStock.getAmount());

            double updateStockAmount = 0;
            if (balanceAmount >= bigOutAmount.doubleValue()) {// 剩余量大于出库的数量
                updateStockAmount = NumberUtils.subtraction(balanceAmount, bigOutAmount.doubleValue());
                bigOutAmount = new BigDecimal("0");// 已经全部出库完
            } else { // 剩余量小于出库的数量
                updateStockAmount = 0;
                bigOutAmount = NumberUtils.subtraction2(bigOutAmount.doubleValue(), balanceAmount);
            }

            WareHouseStock condition = new WareHouseStock();
            condition.setId(wareHouseStock.getId());
            condition.setAmount(updateStockAmount);
            int r = epWareHouseStockMapper.updateAmountById(condition);
            if (r < 1) {
                throw new GoodsException("仓库中商品库存不足,请重试");
            }

            // 完成出库
            if (bigOutAmount.doubleValue() == 0) {
                break;
            }
        }

        // 仓库中的数量都已出完,仍然有数量未出库
        if (bigOutAmount.doubleValue() > 0) {
            throw new GoodsException("仓库中商品库存不足,请重试");
        }

        return true;
    }
}
