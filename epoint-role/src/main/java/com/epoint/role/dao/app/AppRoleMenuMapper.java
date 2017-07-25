package com.epoint.role.dao.app;

import com.epoint.dao.BaseMapper;
import com.epoint.role.app.entity.AppRoleMenu;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppRoleMenuMapper extends BaseMapper<AppRoleMenu> {
    Long insertAppRoleMenu(AppRoleMenu appRoleMenu);

    List<AppRoleMenu> queryByRoleId(@Param("roleId") Long roleId);
}