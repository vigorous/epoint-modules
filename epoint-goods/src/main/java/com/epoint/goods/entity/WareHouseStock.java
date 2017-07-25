package com.epoint.goods.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_warehouse_stock
 */
public class WareHouseStock extends BaseEntity {
    private Long id;

    /**
     * 仓库编号
     */
    private Long warehouseId;

    /**
     * 库存编号， 可以不使用，而用 goods_id 和 erp_goods_stock关联
     */
    private Long stockId;

    /**
     * 库存商品编号
     */
    private Long goodsId;

    /**
     * 库存所属门店编号
     */
    private Long storeId;

    /**
     * 库存数量，初始数量为采购数量，出库后需要减少
     */
    private Double amount;

    /**
     * 采购订单编号
     */
    private Long supplyOrderId;

    /**
     * 库位编号
     */
    private String stockNo;

    /**
     * 采购价格（成本价）
     */
    private Double purchasePrice;

    /**
     * 本次入库的数量
     */
    private Double initAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getSupplyOrderId() {
        return supplyOrderId;
    }

    public void setSupplyOrderId(Long supplyOrderId) {
        this.supplyOrderId = supplyOrderId;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(Double initAmount) {
        this.initAmount = initAmount;
    }
}