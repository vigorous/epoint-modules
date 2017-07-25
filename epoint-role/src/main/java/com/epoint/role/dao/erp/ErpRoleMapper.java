package com.epoint.role.dao.erp;

import com.epoint.dao.BaseMapper;
import com.epoint.role.erp.dto.ErpRoleMenuDTO;
import com.epoint.role.erp.entity.ErpRole;

import java.util.List;
import java.util.Map;

public interface ErpRoleMapper extends BaseMapper<ErpRole> {
    List<Long> queryMenuByRoleId(Long roleId);
}