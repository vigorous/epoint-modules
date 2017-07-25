package com.epoint.staff.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.staff.dto.StaffDTO;
import com.epoint.staff.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EPStaffMapper extends BaseMapper<Staff> {

    /**
     * 查询门店超级管理员员工
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> querySuperAdminStaff(@Param("storeId") Long storeId);

    /**
     * 查询门店某类型的员工
     *
     * @param storeId  门店ID
     * @param roleType 角色类型
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryRoleTypeOfStoreStaff(@Param("storeId") Long storeId, @Param("roleType") Integer roleType);

    /**
     * 查询有开单权限的门店员工
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryCanOrderStoreStaff(@Param("storeId") Long storeId);

    /**
     * 查询有收银权限的门店员工
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryCanCashStoreStaff(@Param("storeId") Long storeId);

    /**
     * 查询有快速开单权限的门店员工
     *
     * @param storeId 门店ID
     * @return StaffDTO
     */
    StaffDTO queryCanQuickOrderStoreStaff(@Param("storeId") Long storeId);

    /**
     * 查询有维修开单权限的门店员工
     *
     * @param storeId 门店ID
     * @return StaffDTO
     */
    StaffDTO queryCanRepairOrderStoreStaff(@Param("storeId") Long storeId);

    /**
     * 根据员工ID、门店ID获取员工信息
     *
     * @param staffId 员工ID
     * @param storeId 门店ID
     * @return StaffDTO
     */
    StaffDTO queryStaffByCondition(@Param("staffId") Long staffId, @Param("storeId") Long storeId);
}