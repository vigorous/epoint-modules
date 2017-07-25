package com.epoint.staff.service.impl;

import com.epoint.role.dao.erp.ErpRoleMapper;
import com.epoint.staff.constant.Constant;
import com.epoint.staff.dao.EPStaffMapper;
import com.epoint.staff.dto.StaffDTO;
import com.epoint.staff.exception.StaffException;
import com.epoint.staff.service.IEPStaffService;
import com.rd.erp.util.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * package:com.epoint.staff.service.impl
 *
 * @Author smallc on 2017/5/25.
 */
@Service
public class EPStaffService implements IEPStaffService {

    private Logger logger = LogManager.getLogger(EPStaffService.class);

    @Autowired
    private EPStaffMapper epStaffMapper;

    @Autowired
    private ErpRoleMapper erpRoleMapper;

    @Override
    public List<StaffDTO> querySuperAdminStaff(Long storeId) {
        return epStaffMapper.querySuperAdminStaff(storeId);
    }

    @Override
    public List<StaffDTO> queryRoleTypeOfStoreStaff(Long storeId, Integer roleType) {
        List<StaffDTO> list = new ArrayList<>();

        //查询门店管理员权限的员工
        List<StaffDTO> staffDTOList = querySuperAdminStaff(storeId);

        //查询某类型的员工
        List<StaffDTO> staffDTOS = epStaffMapper.queryRoleTypeOfStoreStaff(storeId, roleType);

        if (CollectionUtils.isNotEmpty(staffDTOList)) {
            list.addAll(staffDTOList);
        }

        if (CollectionUtils.isNotEmpty(staffDTOS)) {
            list.addAll(staffDTOS);
        }


        return list;
    }

    @Override
    public List<StaffDTO> queryCanOrderStoreStaff(Long storeId) {
        List<StaffDTO> list = new ArrayList<>();

        //查询门店管理员权限的员工
        List<StaffDTO> staffDTOList = querySuperAdminStaff(storeId);

        //查询门店有开单权限的员工
        List<StaffDTO> staffDTOS = epStaffMapper.queryCanOrderStoreStaff(storeId);

        if (CollectionUtils.isNotEmpty(staffDTOList)) {
            list.addAll(staffDTOList);
        }

        if (CollectionUtils.isNotEmpty(staffDTOS)) {
            list.addAll(staffDTOS);
        }

        return list;
    }

    @Override
    public List<StaffDTO> queryCanCashStoreStaff(Long storeId) {
        List<StaffDTO> list = new ArrayList<>();

        //查询门店管理员权限的员工
        List<StaffDTO> staffDTOList = querySuperAdminStaff(storeId);

        //查询门店有收银权限的员工
        List<StaffDTO> staffDTOS = epStaffMapper.queryCanCashStoreStaff(storeId);

        if (CollectionUtils.isNotEmpty(staffDTOList)) {
            list.addAll(staffDTOList);
        }

        if (CollectionUtils.isNotEmpty(staffDTOS)) {
            list.addAll(staffDTOS);
        }

        return list;
    }

    @Override
    public Map<String, Boolean> getStaffPrivilege(Long staffId, Long storeId) {

        Map<String, Boolean> map = initMap(false);
        //根据员工ID查询员工角色roleId
        StaffDTO staffDTO = epStaffMapper.queryStaffByCondition(staffId, storeId);

        if (staffDTO == null) {
            logger.debug("staff_id:{}", staffId);
            throw new StaffException("员工不存在");
        }

        if (staffDTO.getRoleId() == null) {
            logger.debug("role_id:{}", "角色为空");
            throw new StaffException("员工角色为空");
        }

        if (staffDTO.getRoleId() == 0) {//超级管理员权限
            return initMap(true);
        }

        /**
         * 查询角色菜单权限
         * 1.快速开单（开单、派工、派发领料）和 开单收银（开单、付款）
         * 2.维修开单（开单、派工、派发领料）
         * 3.业务控制中心（出库）
         * 4.订单查询（支付）
         */
        List<Long> menuIds = erpRoleMapper.queryMenuByRoleId(staffDTO.getRoleId());
        //快速开单的开单权限
        if (menuIds.contains(Constant.CASH_BILLING) || menuIds.contains(Constant.QUICK_BILLING)) {
            map.put(Constant.QUICK_ORDER_PRIVILEGE, true);
        }
        //快速开单的派工权限
        if (menuIds.contains(Constant.QUICK_ASSIGN)) {
            map.put(Constant.QUICK_ORDER_ASSIGN_PRIVILEGE, true);
        }
        //快速开单的派发领料权限
        if (menuIds.contains(Constant.QUICK_PICK)) {
            map.put(Constant.QUICK_ORDER_PICK_PRIVILEGE, true);
        }
        if (menuIds.contains(Constant.REPAIR_BILLING)) {
            map.put(Constant.REPAIR_ORDER_PRIVILEGE, true);
        }
        if (menuIds.contains(Constant.REPAIR_ASSIGN)) {
            map.put(Constant.REPAIR_ORDER_ASSIGN_PRIVILEGE, true);
        }
        if (menuIds.contains(Constant.REPAIR_PICK)) {
            map.put(Constant.REPAIR_ORDER_PICK_PRIVILEGE, true);
        }
        if (menuIds.contains(Constant.GOODS_OUT)) {
            map.put(Constant.GOODS_OUT_PRIVILEGE, true);
        }
        if (menuIds.contains(Constant.CASH_PAY) || menuIds.contains(Constant.ORDER_LIST_PAY)) {
            map.put(Constant.CASH_PAY_PRIVILEGE, true);
        }

        return map;
    }

    public Map<String, Boolean> initMap(Boolean flag) {
        Map<String, Boolean> map = new HashMap<>();
        if (flag) {
            map.put(Constant.QUICK_ORDER_PRIVILEGE, true);
            map.put(Constant.QUICK_ORDER_ASSIGN_PRIVILEGE, true);
            map.put(Constant.QUICK_ORDER_PICK_PRIVILEGE, true);
            map.put(Constant.REPAIR_ORDER_PRIVILEGE, true);
            map.put(Constant.REPAIR_ORDER_ASSIGN_PRIVILEGE, true);
            map.put(Constant.REPAIR_ORDER_PICK_PRIVILEGE, true);
            map.put(Constant.CASH_PAY_PRIVILEGE, true);
            map.put(Constant.GOODS_OUT_PRIVILEGE, true);
        } else {
            map.put(Constant.QUICK_ORDER_PRIVILEGE, false);
            map.put(Constant.QUICK_ORDER_ASSIGN_PRIVILEGE, false);
            map.put(Constant.QUICK_ORDER_PICK_PRIVILEGE, false);
            map.put(Constant.REPAIR_ORDER_PRIVILEGE, false);
            map.put(Constant.REPAIR_ORDER_ASSIGN_PRIVILEGE, false);
            map.put(Constant.REPAIR_ORDER_PICK_PRIVILEGE, false);
            map.put(Constant.CASH_PAY_PRIVILEGE, false);
            map.put(Constant.GOODS_OUT_PRIVILEGE, false);
        }
        return map;
    }
}
