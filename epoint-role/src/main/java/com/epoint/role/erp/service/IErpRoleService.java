package com.epoint.role.erp.service;

/**
 * Created by yyy on 2017-05-23.
 * erp角色权限
 */
public interface IErpRoleService {
    /**
     * staffId 或 roleId 必传一个
     * @param staffId 员工Id
     * @param roleId 角色Id
     * @param menuId 菜单Id
     * @return true 拥有该菜单权限，false 没有该菜单权限
     */
    boolean isAuthority(Long staffId,Long roleId,Long menuId);


}
