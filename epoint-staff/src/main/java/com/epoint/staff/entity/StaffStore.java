package com.epoint.staff.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 琛ㄥ悕:erp_staff_store
 */
public class StaffStore extends BaseEntity {
    private Long id;

    /**
     * 工号
     */
    private String workNo;

    /**
     * 员工表Id
     */
    private Long erpStaffId;

    private Long erpStoreId;

    /**
     * 员工星级
     */
    private Integer star;

    /**
     * 技术等级
     */
    private Integer techLevel;

    /**
     * 技术描述
     */
    private String tech;

    /**
     * 月薪
     */
    private Double salary;

    /**
     * 0：正常
     * 1：删除（表示离职）
     */
    private String status;

    private Long erpDeptId;

    /**
     * 权限ID
     */
    private Long roleId;

    /**
     * 入店时间
     */
    private Date enterDate;

    /**
     * 离职日期
     */
    private Date leaveDate;

    private Date loginTime;

    /**
     * 用于总部员工下派到门店， 指向总部的ID
     */
    private Long parentStoreId;

    /**
     * 用于总部员工下派到门店， 指向总部员工的ID
     */
    private Long parentStaffStoreId;

    /**
     * 岗位ID
     */
    private Long erpStationId;

    /**
     * 是否默认登录0：否，1：是。
     */
    private Integer isDefault;

    /**
     * APP角色权限
     */
    private Long appRoleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public Long getErpStaffId() {
        return erpStaffId;
    }

    public void setErpStaffId(Long erpStaffId) {
        this.erpStaffId = erpStaffId;
    }

    public Long getErpStoreId() {
        return erpStoreId;
    }

    public void setErpStoreId(Long erpStoreId) {
        this.erpStoreId = erpStoreId;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(Integer techLevel) {
        this.techLevel = techLevel;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getErpDeptId() {
        return erpDeptId;
    }

    public void setErpDeptId(Long erpDeptId) {
        this.erpDeptId = erpDeptId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Long getParentStoreId() {
        return parentStoreId;
    }

    public void setParentStoreId(Long parentStoreId) {
        this.parentStoreId = parentStoreId;
    }

    public Long getParentStaffStoreId() {
        return parentStaffStoreId;
    }

    public void setParentStaffStoreId(Long parentStaffStoreId) {
        this.parentStaffStoreId = parentStaffStoreId;
    }

    public Long getErpStationId() {
        return erpStationId;
    }

    public void setErpStationId(Long erpStationId) {
        this.erpStationId = erpStationId;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(Long appRoleId) {
        this.appRoleId = appRoleId;
    }
}