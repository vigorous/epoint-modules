package com.epoint.role.dao.app;

import com.epoint.role.app.entity.AppRole;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppRoleMapper extends BaseMapper<AppRole> {

    int deleteById(Long id);

    int insert(AppRole appRole);

    AppRole selectById(Long id);

    AppRole queryAppRoleByStaffId(Long id);

    int updateById(AppRole appRole);

    List<AppRole> queryListByPage(Map<String, Object> map);

    int queryNumByPage(Map<String, Object> map);

    List<AppRole> queryListByStoreId(@Param("storeId") Long storeId);

    List<AppRole> queryByStoreId();
}