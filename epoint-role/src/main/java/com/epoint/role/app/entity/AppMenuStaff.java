package com.epoint.role.app.entity;

import com.epoint.entity.BaseEntity;

/**
 * 表名:app_menu_staff
 */
public class AppMenuStaff extends BaseEntity {

    private Integer id;
    /**
     * 是否热门 0:否，1：是
     */
    private String isHot;

    /**
     * 是否图标
     */
    private String isImg;

    /**
     * 员工ID
     */
    private Long  staffId;
    private Integer menuId;
    private Long storeId;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getIsImg() {
        return isImg;
    }

    public void setIsImg(String isImg) {
        this.isImg = isImg;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}