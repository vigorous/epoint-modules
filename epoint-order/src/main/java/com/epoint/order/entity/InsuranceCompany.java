package com.epoint.order.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_insurance_company
 */
public class InsuranceCompany extends BaseEntity {
    private Long id;

    /**
     * 保险公司名称
     */
    private String name;

    /**
     * 判断是否删除
     */
    private Boolean status;

    /**
     * 所属门店
     */
    private Long storeId;

    /**
     * 保险全称
     */
    private String allName;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getAllName() {
        return allName;
    }

    public void setAllName(String allName) {
        this.allName = allName;
    }
}