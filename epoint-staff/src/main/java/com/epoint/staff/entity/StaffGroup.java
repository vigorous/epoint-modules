package com.epoint.staff.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:erp_staff_group
 */
public class StaffGroup extends BaseEntity {
    private Long id;

    /**
     * 门店ID
     */
    private Long storeId;

    /**
     * 施工小组名称
     */
    private String name;

    /**
     * 施工小组成员
     */
    private String staffIds;

    /**
     * 0:正常,1:删除
     */
    private Integer status;

    /**
     * 0:销售组;1:施工组;2销售和施工都包含的组
     */
    private String type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(String staffIds) {
        this.staffIds = staffIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}