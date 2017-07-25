package com.epoint.tmsg.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wtp_msg_template
 */
public class MsgTemplate extends BaseEntity {
    /**
     * 模版短id
     */
    private String templateIdShort;

    /**
     * 行业ID
     */
    private Integer industryCode;

    /**
     * 模版消息标题
     */
    private String title;

    /**
     * 模版消息标题-ERP开启显示
     */
    private String subTitle;

    /**
     * 模版
     */
    private String contentTemplate;

    /**
     * 模版内容举例
     */
    private String contentExample;

    public String getTemplateIdShort() {
        return templateIdShort;
    }

    public void setTemplateIdShort(String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }

    public Integer getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Integer industryCode) {
        this.industryCode = industryCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContentTemplate() {
        return contentTemplate;
    }

    public void setContentTemplate(String contentTemplate) {
        this.contentTemplate = contentTemplate;
    }

    public String getContentExample() {
        return contentExample;
    }

    public void setContentExample(String contentExample) {
        this.contentExample = contentExample;
    }
}