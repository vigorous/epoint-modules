package com.epoint.role.dao.app;

import com.epoint.dao.BaseMapper;
import com.epoint.role.app.entity.AppMenuStaff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMenuStaffMapper extends BaseMapper<AppMenuStaff> {
    List<AppMenuStaff> queryAll(@Param("staffId") Long staffId, @Param("storeId") Long storeId);
    List<AppMenuStaff> queryIsHot(@Param("staffId") Long staffId, @Param("storeId") Long storeId);
    List<AppMenuStaff> queryIsImg(@Param("staffId") Long staffId, @Param("storeId") Long storeId);
    int updateByMenuId(AppMenuStaff appMenuStaff);
}