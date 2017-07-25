package com.epoint.role.app.entity;

import com.epoint.entity.BaseEntity;

/**
 * 琛ㄥ悕:app_role
 */
public class AppRole extends BaseEntity {
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
     * 0:正常；1：删除；
     */
    private String status;

    /**
     * 角色类型
     */
    private String roleType;

    /**
     * 是否内置的角色。0:非内置；1:内置的技师角色;2:内置的销售角色;3:内置的前台角色;4：内置的老板角色
     */
    private Integer defType;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getDefType() {
        return defType;
    }

    public void setDefType(Integer defType) {
        this.defType = defType;
    }
}