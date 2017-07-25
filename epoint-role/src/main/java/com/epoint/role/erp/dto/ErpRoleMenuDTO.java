package com.epoint.role.erp.dto;

import com.epoint.role.erp.entity.ErpMenu;

/**
 * Created by yyy on 2017-05-23.
 */
public class ErpRoleMenuDTO  {
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 角色id
     */
    private Long roleId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
