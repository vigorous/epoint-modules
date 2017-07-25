package com.epoint.staff.service;

import com.epoint.staff.dto.StaffDTO;

import java.util.List;
import java.util.Map;

/**
 * package:com.epoint.staff.service
 *
 * @Author smallc on 2017/5/25.
 */
public interface IEPStaffService {

    /**
     * 查询门店超级管理员员工
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> querySuperAdminStaff(Long storeId);

    /**
     * 查询门店某类型的员工
     *
     * @param storeId  门店ID
     * @param roleType 角色类型
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryRoleTypeOfStoreStaff(Long storeId, Integer roleType);

    /**
     * 查询有开单权限的门店员工（快速开单、维修开单）
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryCanOrderStoreStaff(Long storeId);

    /**
     * 查询有收银权限的门店员工
     *
     * @param storeId 门店ID
     * @return List<StaffDTO>
     */
    List<StaffDTO> queryCanCashStoreStaff(Long storeId);

    /**
     * 获取员工权限
     * 只针对快速开单、维修开单、业务控制中心的权限
     *
     * @param staffId 员工ID
     * @param storeId 门店ID
     * @return Map<String, Boolean>
     */
    Map<String, Boolean> getStaffPrivilege(Long staffId, Long storeId);
}
