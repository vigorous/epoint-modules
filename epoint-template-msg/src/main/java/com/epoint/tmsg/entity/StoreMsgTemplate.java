package com.epoint.tmsg.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wtp_store_msg_template
 */
public class StoreMsgTemplate extends BaseEntity {
    /**
     * 模版id
     */
    private String templateId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 主行业ID
     */
    private Integer industryCode;

    /**
     * 模版短id
     */
    private String templateIdShort;

    /**
     * 1:开启;0:关闭
     */
    private Integer status;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Integer industryCode) {
        this.industryCode = industryCode;
    }

    public String getTemplateIdShort() {
        return templateIdShort;
    }

    public void setTemplateIdShort(String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}