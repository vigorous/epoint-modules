package com.epoint.role.dao.app;

import com.epoint.role.app.entity.AppMenu;
import com.epoint.dao.BaseMapper;

import java.util.List;

public interface AppMenuMapper extends BaseMapper<AppMenu> {
    List<AppMenu> queryAll();
    List<AppMenu> queryIsHot();
    List<AppMenu> queryIsImg();
    int updateById(AppMenu appMenu);
}