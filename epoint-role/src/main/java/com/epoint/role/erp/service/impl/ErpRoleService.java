package com.epoint.role.erp.service.impl;

import com.epoint.role.dao.erp.ErpRoleMapper;
import com.epoint.role.erp.service.IErpRoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by yyy on 2017-05-23.
 */
public class ErpRoleService implements IErpRoleService {
    private static final Logger logger = LogManager.getLogger(ErpRoleService.class);
    private ErpRoleMapper erpRoleMapper;
//    private
    @Override
    public boolean isAuthority(Long staffId, Long roleId, Long menuId) {
        if(staffId == null && roleId == null){
            logger.debug("查询权限时，员工id与角色id不能同时NULL");
            return false;
        }else if(roleId != null){

        }

        return false;
    }
}
