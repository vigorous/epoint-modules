package com.epoint.role.erp.entity;

import com.epoint.entity.BaseEntity;

/**
 * erp角色表:erp_role
 */
public class ErpRole extends BaseEntity {
    private Long id;

    private String name;

    private Long erpStoreId;

    private String remark;

    private String limitIds;

    /**
     * 操作人
     */
    private String createName;

    /**
     * 权限设置状态，0:正常，1:已删除
     */
    private Long status;

    /**
     * 分店角色指向总店的ID
     */
    private Long parentStoreId;

    /**
     * 指向总店的role_id
     */
    private Long parentRoleId;

    /**
     * 可用客户端,0:门店ERP,1:员工APP,2:管理APP
     */
    private String clientAccess;

    /**
     * 扫码支付，1表示有权限
     */
    private String scanPay;

    /**
     * 订单编辑权限7：价格修改，8：订单优惠
     */
    private String orderEdit;

    /**
     * 角色类型 详情见枚举RoleConstant
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

    public Long getErpStoreId() {
        return erpStoreId;
    }

    public void setErpStoreId(Long erpStoreId) {
        this.erpStoreId = erpStoreId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLimitIds() {
        return limitIds;
    }

    public void setLimitIds(String limitIds) {
        this.limitIds = limitIds;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Long getParentRoleId() {
        return parentRoleId;
    }

    public void setParentRoleId(Long parentRoleId) {
        this.parentRoleId = parentRoleId;
    }

    public String getClientAccess() {
        return clientAccess;
    }

    public void setClientAccess(String clientAccess) {
        this.clientAccess = clientAccess;
    }

    public String getScanPay() {
        return scanPay;
    }

    public void setScanPay(String scanPay) {
        this.scanPay = scanPay;
    }

    public String getOrderEdit() {
        return orderEdit;
    }

    public void setOrderEdit(String orderEdit) {
        this.orderEdit = orderEdit;
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