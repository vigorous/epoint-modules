package com.epoint.goods.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_goods_stock
 */
public class GoodsStock extends BaseEntity {
    private Long id;

    private Long goodsId;

    /**
     * 库存数量
     */
    private Double amount;

    /**
     * 0-未上架,1-已上架,2-已下架
     */
    private String status;

    /**
     * 是否APP上架:0否1是
     */
    private Boolean isGrounding;

    private Long storeId;

    /**
     * 销售价
     */
    private Double sellPrice;

    private Double sellActivityPrice;

    /**
     * 采购价
     */
    private Double batchPrice;

    private Double batchActivityPrice;

    private Double purchasePrice;

    private String actSts;

    /**
     * 最小库存
     */
    private Double minAmount;

    /**
     * 最大库存
     */
    private Double maxAmount;

    private String storehouse;

    private String stockNo;

    /**
     * 最低零售价
     */
    private Double minSellPrice;

    /**
     * 内部结算价
     */
    private Double insidePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsGrounding() {
        return isGrounding;
    }

    public void setIsGrounding(Boolean isGrounding) {
        this.isGrounding = isGrounding;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getSellActivityPrice() {
        return sellActivityPrice;
    }

    public void setSellActivityPrice(Double sellActivityPrice) {
        this.sellActivityPrice = sellActivityPrice;
    }

    public Double getBatchPrice() {
        return batchPrice;
    }

    public void setBatchPrice(Double batchPrice) {
        this.batchPrice = batchPrice;
    }

    public Double getBatchActivityPrice() {
        return batchActivityPrice;
    }

    public void setBatchActivityPrice(Double batchActivityPrice) {
        this.batchActivityPrice = batchActivityPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getActSts() {
        return actSts;
    }

    public void setActSts(String actSts) {
        this.actSts = actSts;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(String storehouse) {
        this.storehouse = storehouse;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public Double getMinSellPrice() {
        return minSellPrice;
    }

    public void setMinSellPrice(Double minSellPrice) {
        this.minSellPrice = minSellPrice;
    }

    public Double getInsidePrice() {
        return insidePrice;
    }

    public void setInsidePrice(Double insidePrice) {
        this.insidePrice = insidePrice;
    }
}