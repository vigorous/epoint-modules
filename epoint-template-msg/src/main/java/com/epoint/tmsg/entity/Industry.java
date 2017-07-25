package com.epoint.tmsg.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wtp_industry
 */
public class Industry extends BaseEntity {
    /**
     * 行业ID
     */
    private Integer industryCode;

    /**
     * 一级行业分类
     */
    private String firstClass;

    /**
     * 二级行业分类
     */
    private String secondClass;

    public Integer getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Integer industryCode) {
        this.industryCode = industryCode;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }
}