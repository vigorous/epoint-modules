package com.epoint.carcheck.dao;

import com.epoint.carcheck.entity.EPCarCheck;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EPCarCheckMapper extends BaseMapper<EPCarCheck> {
   EPCarCheck selectNoOrderCarCheck(@Param("memberId") Long memberId);
}