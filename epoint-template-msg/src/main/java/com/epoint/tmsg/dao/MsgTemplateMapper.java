package com.epoint.tmsg.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.tmsg.entity.MsgTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgTemplateMapper extends BaseMapper<MsgTemplate> {
    List<MsgTemplate> queryAll();
    MsgTemplate selectById(@Param("templateIdShort") String templateIdShort);
}