package com.epoint.staff.dto;

import com.epoint.staff.entity.Staff;

/**
 * package:com.epoint.staff.dto
 *
 * @Author smallc on 2017/5/25.
 */
public class StaffDTO extends Staff {

    private Long storeId;

    private Long roleId;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
