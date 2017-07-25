package com.epoint.flow.service.impl;

import com.epoint.flow.dto.FlowDTO;
import com.epoint.flow.entity.FlowNode;
import com.epoint.flow.entity.FlowProcess;
import com.epoint.flow.service.IFlowProcessService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import spring.test.BeanTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xishengchun on 2017-05-18.
 */
public class FlowProcessServiceTest extends BeanTest {


    @Autowired
    private IFlowProcessService flowProcessService;

    @Test
    public void testGetFlowDetail() {
        Long flowId = 1L;
        FlowDTO flowDetail = flowProcessService.getFlowDetail(flowId);
        System.out.println(flowDetail.getFlowProcess().toString());
        System.out.println(flowDetail.getFlowNodeList().toString());
        Assert.isTrue(flowDetail.getFlowProcess() == null);
        Assert.isTrue(flowDetail.getFlowNodeList() == null);
    }

    @Test
    @Rollback(false)
    public void testCreateFlow() {
        Long storeId = 2947L;
        Long childStoreId = null;
        flowProcessService.createFlow(storeId, null, 1);
        //flowProcessService.createFlow(storeId, childStoreId, 2);
    }

    @Test
    @Rollback(false)
    public void testUpdateFlow() {
        FlowDTO flowDTO = new FlowDTO();
        FlowProcess flowProcess = new FlowProcess();
        flowProcess.setId(15L);
        flowProcess.setDeductStockWay(0);

        FlowNode node1 = new FlowNode("1000", 1);
        FlowNode node2 = new FlowNode("2000", 1);
        FlowNode node3 = new FlowNode("3000", 1);
        FlowNode node4 = new FlowNode("4000", 1);
        FlowNode node5 = new FlowNode("5000", 1);
        FlowNode node6 = new FlowNode("6000", 1);
        FlowNode node7 = new FlowNode("7000", 1);
        FlowNode node8 = new FlowNode("8000", 1);

        List<FlowNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        nodes.add(node8);
        flowDTO.setFlowProcess(flowProcess);
        flowDTO.setFlowNodeList(nodes);

        flowProcessService.updateFlow(flowDTO);
    }

    @Test
    public void testGetHistoryFlowDetail() {
        Long flowId = 13L;
        FlowDTO flowDTO = flowProcessService.getHistoryFlowDetail(flowId);
        System.out.println(flowDTO.getFlowProcess().toString());
        System.out.println(flowDTO.getFlowNodeList().toString());
    }

    @Test
    public void testValidNodeStatus() {
        Long storeId = 1L;
        Integer type = 0;
        String nodeCode = "4000";
        boolean flag = flowProcessService.validNodeStatus(storeId, type, nodeCode);
        System.out.println(flag);
    }

    @Test
    public void isOutDeductStock() {
        Long storeId = 1L;
        Integer type = 0;
        boolean flag = flowProcessService.isOutDeductStock(storeId,type);
        System.out.println(flag);
    }

}
