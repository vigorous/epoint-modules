package com.epoint.flow.dto;

import com.epoint.flow.entity.FlowNode;
import com.epoint.flow.entity.FlowProcess;
import com.epoint.flow.enums.FlowConstant;

import java.util.List;

/**
 * @author xishengchun on 2017-05-18.
 *         单个业务流程的详情
 */
public class FlowDTO {

    private FlowProcess flowProcess;

    private List<FlowNode> flowNodeList;

    public boolean isReceptCar() {
        for (FlowNode flowNode : getFlowNodeList()) {
            if (FlowConstant.NodeCode.isReceptCar(flowNode.getNodeCode()) && FlowConstant.NodeStatus.isStart(flowNode.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheckCar() {
        for (FlowNode flowNode : getFlowNodeList()) {
            if (FlowConstant.NodeCode.isCheckCar(flowNode.getNodeCode()) && FlowConstant.NodeStatus.isStart(flowNode.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public boolean isQualityTest() {
        for (FlowNode flowNode : getFlowNodeList()) {
            if (FlowConstant.NodeCode.isQualityControl(flowNode.getNodeCode()) && FlowConstant.NodeStatus.isStart(flowNode.getStatus())) {
                return true;
            }
        }
        return false;
    }

    public FlowProcess getFlowProcess() {
        return flowProcess;
    }

    public void setFlowProcess(FlowProcess flowProcess) {
        this.flowProcess = flowProcess;
    }

    public List<FlowNode> getFlowNodeList() {
        return flowNodeList;
    }

    public void setFlowNodeList(List<FlowNode> flowNodeList) {
        this.flowNodeList = flowNodeList;
    }
}
