package com.epoint.staff.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.staff.entity.StaffGroup;
import org.apache.ibatis.annotations.Param;

public interface EPStaffGroupMapper extends BaseMapper<StaffGroup> {
    /**
     * 根据班组ID查询班组信息
     * @param id 班组ID
     * @return StaffGroup
     */
    StaffGroup queryOneStaffGroup(@Param("id") Long id);
}