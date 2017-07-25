package com.epoint.goods.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.goods.entity.WareHouseStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EPWareHouseStockMapper extends BaseMapper<WareHouseStock> {

    /**
     * 根据条件查询仓库库存信息
     *
     * @param goodsId     商品ID
     * @param storeId     门店ID
     * @param warehouseId 仓库ID（不必填）
     * @return List<WareHouseStock>
     */
    List<WareHouseStock> queryWarehouseStockByCondition(@Param("goodsId") Long goodsId, @Param("storeId") Long storeId, @Param("warehouseId") Long warehouseId);

    /**
     * 根据ID修改仓库库存数量
     * 参数：id, amount
     *
     * @param wareHouseStock
     * @return int
     */
    int updateAmountById(WareHouseStock wareHouseStock);
}