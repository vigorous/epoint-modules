package com.epoint.book.dto;

/**
 * Created by chiang on 2017/5/20.
 */
public class BookInfoPageQueryBean extends BookInfoQueryBean{
    /**
     * 开始行数
     */
    private Integer startRowNo;

    /**
     * 返回行数
     */
    private Integer rows;


    public Integer getStartRowNo() {
        return startRowNo;
    }

    public void setStartRowNo(Integer startRowNo) {
        this.startRowNo = startRowNo;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

}
