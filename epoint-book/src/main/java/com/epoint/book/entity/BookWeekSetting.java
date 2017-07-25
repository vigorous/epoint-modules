package com.epoint.book.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wx_book_week_setting
 */
public class BookWeekSetting extends BaseEntity {
    private Long id;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 周日最大预约人数
     */
    private Integer day1;

    /**
     * 周一最大预约人数
     */
    private Integer day2;

    /**
     * 周二最大预约人数
     */
    private Integer day3;

    /**
     * 周三最大预约人数
     */
    private Integer day4;

    /**
     * 周四最大预约人数
     */
    private Integer day5;

    /**
     * 周五最大预约人数
     */
    private Integer day6;

    /**
     * 周六最大预约人数
     */
    private Integer day7;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getDay1() {
        return day1;
    }

    public void setDay1(Integer day1) {
        this.day1 = day1;
    }

    public Integer getDay2() {
        return day2;
    }

    public void setDay2(Integer day2) {
        this.day2 = day2;
    }

    public Integer getDay3() {
        return day3;
    }

    public void setDay3(Integer day3) {
        this.day3 = day3;
    }

    public Integer getDay4() {
        return day4;
    }

    public void setDay4(Integer day4) {
        this.day4 = day4;
    }

    public Integer getDay5() {
        return day5;
    }

    public void setDay5(Integer day5) {
        this.day5 = day5;
    }

    public Integer getDay6() {
        return day6;
    }

    public void setDay6(Integer day6) {
        this.day6 = day6;
    }

    public Integer getDay7() {
        return day7;
    }

    public void setDay7(Integer day7) {
        this.day7 = day7;
    }
}