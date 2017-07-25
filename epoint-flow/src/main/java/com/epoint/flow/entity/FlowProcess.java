package com.epoint.flow.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:erp_flow_process
 */
public class FlowProcess extends BaseEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 业务流程名称
     */
    private String name;

    /**
     * 类型：0-快速开单，1-维修开单
     */
    private Integer type;

    /**
     * 状态：0-关闭，1-开启，2-删除
     */
    private Integer status;

    /**
     * 减库存方式：0-仓管出库减库存,1-结算减库存
     */
    private Integer deductStockWay;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeductStockWay() {
        return deductStockWay;
    }

    public void setDeductStockWay(Integer deductStockWay) {
        this.deductStockWay = deductStockWay;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}