package com.epoint.tmsg.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wtp_store_template_msg_log
 */
public class StoreTemplateMsgLog extends BaseEntity {
    /**
     * 消息id
     */
    private String msgId;

    /**
     * ERP上会员id
     */
    private Long memberId;

    /**
     * 行业ID
     */
    private Integer industryCode;

    /**
     * 模版短id
     */
    private String templateIdShort;

    /**
     * 模版id
     */
    private String templateId;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 公众号id
     */
    private String fromUserId;

    /**
     * 接收通知用户openid
     */
    private String toUserOpenId;

    /**
     * 消息跳转地址
     */
    private String msgUrl;

    /**
     * 消息跳转的小程序appid
     */
    private String appId;

    /**
     * 消息跳转的小程序路径
     */
    private String pagePath;

    /**
     * 消息内容
     */
    private String content;

    private String status;

    private String statusDesc;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserOpenId() {
        return toUserOpenId;
    }

    public void setToUserOpenId(String toUserOpenId) {
        this.toUserOpenId = toUserOpenId;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}