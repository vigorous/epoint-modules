package com.epoint.role.boss.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:boss_role
 */
public class BossRole extends BaseEntity {
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 门店id
     */
    private Long storeId;

    /**
     * 父门店id (当前门店为总店时 本字段与store_id相同)
     */
    private Long parentStoreId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 0 正常 1 删除
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}