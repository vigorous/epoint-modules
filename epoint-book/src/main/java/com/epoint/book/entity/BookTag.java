package com.epoint.book.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wx_book_tag
 */
public class BookTag extends BaseEntity {
    private Integer id;

    private String name;

    private Long storeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}