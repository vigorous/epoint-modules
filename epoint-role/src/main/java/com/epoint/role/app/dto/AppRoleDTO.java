package com.epoint.role.app.dto;

import com.epoint.role.app.entity.AppRole;

/**
 * Created by xuwenqian on 2017/5/20.
 */
public class AppRoleDTO extends AppRole{
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
