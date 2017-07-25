package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_order_credit_discount
 */
public class OrderCreditDiscount extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 项目ID/商品ID
     */
    private Long itemId;

    /**
     * 项目类型/商品类型：1-项目，2-商品
     */
    private String itemType;

    /**
     * 类型：1-总优惠，2-单个优惠
     */
    private String type;

    /**
     * 优惠金额
     */
    private Double amount;

    /**
     * 订单总优惠
     */
    private Double totalAmount;

    /**
     * 状态：0-有效，1-无效
     */
    private String status;

    /**
     * 订单ID
     */
    private Long workOrderId;

    /**
     * 门店ID
     */
    private Long storeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}