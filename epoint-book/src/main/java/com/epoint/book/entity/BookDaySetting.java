package com.epoint.book.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wx_book_day_setting
 */
public class BookDaySetting extends BaseEntity {
    private Long id;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 预约日期。 格式:2017-05-17
     */
    private String bookDate;

    /**
     * 最大预约人数
     */
    private Integer maxNum;

    /**
     * 已预约人数
     */
    private Integer actMaxNum;

    /**
     * 是否来自按周设置. 1:周设置;0:具体设置
     */
    private Integer isWeek;

    private Integer week; //一周中第几天

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

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getActMaxNum() {
        return actMaxNum;
    }

    public void setActMaxNum(Integer actMaxNum) {
        this.actMaxNum = actMaxNum;
    }

    public Integer getIsWeek() {
        return isWeek;
    }

    public void setIsWeek(Integer isWeek) {
        this.isWeek = isWeek;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}