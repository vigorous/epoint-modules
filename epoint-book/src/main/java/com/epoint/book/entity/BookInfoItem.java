package com.epoint.book.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:wx_book_info_item
 */
public class BookInfoItem extends BaseEntity {
    private Long id;

    /**
     * 预约ID
     */
    private Long bookId;

    /**
     * 项目ID
     */
    private Long itemId;

    /**
     * 项目名称
     */
    private String itemName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}