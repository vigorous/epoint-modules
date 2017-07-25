package com.epoint.flow.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.flow.entity.FlowNode;
import com.epoint.flow.entity.FlowNodeLog;

import java.util.List;

public interface FlowNodeLogMapper extends BaseMapper<FlowNodeLog> {

    /**
     * 根据业务流程ID查询节点日志记录
     * @param flowNodeLog 节点日志记录
     * @return List<FlowNodeLog>
     */
    List<FlowNodeLog> selectByFlowId(FlowNodeLog flowNodeLog);

    /**
     * 根据业务流程ID、流程节点编码查询流程节点信息
     * @param flowNodeLog
     * @return FlowNodeLog
     */
    FlowNodeLog selectByFlowIdAndNodeCode(FlowNodeLog flowNodeLog);
}