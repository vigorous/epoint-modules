package com.epoint.flow.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.flow.entity.FlowNode;

import java.util.List;

public interface FlowNodeMapper extends BaseMapper<FlowNode> {

    List<FlowNode> selectByFlowId(FlowNode flowNode);

    /**
     * 根据业务流程ID、流程节点编码查询流程节点信息
     * @param flowNode
     * @return FlowNode
     */
    FlowNode selectByFlowIdAndNodeCode(FlowNode flowNode);
}