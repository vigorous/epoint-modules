package com.epoint.tmsg.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wtp_store_industry
 */
public class StoreIndustry extends BaseEntity {
    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 主行业ID
     */
    private Integer primaryIndustryCode;

    /**
     * 副行业ID
     */
    private Integer secondaryIndustryCode;

    /**
     * 状态 1:已开启;0:开启失败
     */
    private Integer status;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getPrimaryIndustryCode() {
        return primaryIndustryCode;
    }

    public void setPrimaryIndustryCode(Integer primaryIndustryCode) {
        this.primaryIndustryCode = primaryIndustryCode;
    }

    public Integer getSecondaryIndustryCode() {
        return secondaryIndustryCode;
    }

    public void setSecondaryIndustryCode(Integer secondaryIndustryCode) {
        this.secondaryIndustryCode = secondaryIndustryCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}