package com.epoint.tmsg.dto;

import com.epoint.tmsg.enums.StoreMsgTemplateConstant;

/**
 * Created by chiang on 2017/5/13.
 */
public class StoreMsgTemplateDto implements java.io.Serializable{

    /**
     * 模版消息标题
     */
    private String title;

    /**
     * 模版消息标题-ERP开启显示
     */
    private String subTitle;

    private String templateIdShort;

    private  Integer status;

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


    public String getTemplateIdShort() {
        return templateIdShort;
    }


    public void setTemplateIdShort(String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }

    public Integer getStatus() {
        if (status == null){
            return StoreMsgTemplateConstant.Status.CLOSED.getCode();
        }
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
