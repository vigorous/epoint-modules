package com.epoint.flow.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.flow.entity.FlowNode;
import com.epoint.flow.entity.FlowProcess;

import java.util.List;

public interface FlowProcessMapper extends BaseMapper<FlowProcess> {

    List<FlowProcess> selectBy(FlowProcess flowProcess);


}