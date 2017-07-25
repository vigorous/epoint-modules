package com.epoint.book.dto;

/**
 * Created by chiang on 2017/5/20.
 */
public class BookInfoQueryBean implements java.io.Serializable{
    private Long storeId;

    /**
     * 预约时间范围-开始时间
     */
    private String bookDateStart;

    /**
     * 预约时间范围-结束时间
     */
    private String bookDateEnd;

    /**
     * 条件值
     */
    private String condition;

    /**
     * 条件字段
     * 1:车牌;2:手机;3:客户姓名
     */
    private Integer conditionType;


    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getBookDateStart() {
        return bookDateStart;
    }

    public void setBookDateStart(String bookDateStart) {
        this.bookDateStart = bookDateStart;
    }

    public String getBookDateEnd() {
        return bookDateEnd;
    }

    public void setBookDateEnd(String bookDateEnd) {
        this.bookDateEnd = bookDateEnd;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getConditionType() {
        return conditionType;
    }

    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }


}
