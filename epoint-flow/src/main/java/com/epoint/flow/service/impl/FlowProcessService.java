package com.epoint.flow.service.impl;

import com.epoint.flow.dao.FlowNodeLogMapper;
import com.epoint.flow.dao.FlowNodeMapper;
import com.epoint.flow.dao.FlowProcessLogMapper;
import com.epoint.flow.dao.FlowProcessMapper;
import com.epoint.flow.dto.FlowDTO;
import com.epoint.flow.entity.FlowNode;
import com.epoint.flow.entity.FlowNodeLog;
import com.epoint.flow.entity.FlowProcess;
import com.epoint.flow.entity.FlowProcessLog;
import com.epoint.flow.enums.FlowConstant;
import com.epoint.flow.exception.FlowException;
import com.epoint.flow.service.IFlowProcessService;
import com.epoint.order.dao.EPOrderMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xishengchun on 2017-05-18.
 */
@Service
public class FlowProcessService implements IFlowProcessService {

    private Logger logger = LogManager.getLogger(FlowProcessService.class);

    @Resource
    private FlowProcessMapper flowProcessMapper;

    @Resource
    private FlowNodeMapper flowNodeMapper;

    @Resource
    private FlowProcessLogMapper flowProcessLogMapper;

    @Resource
    private FlowNodeLogMapper flowNodeLogMapper;

    @Resource
    private EPOrderMapper epOrderMapper;

    @Override
    public FlowDTO getFlowDetail(Integer flowType, Long storeId) {
        FlowProcess flowProcessCondition = new FlowProcess();
        flowProcessCondition.setType(flowType);
        flowProcessCondition.setStoreId(storeId);
        flowProcessCondition.setStatus(FlowConstant.FlowProcessStatus.START.code);

        List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcessCondition);
        if (CollectionUtils.isEmpty(flowProcessList)) {
            return null;
        }

        FlowProcess flowProcess = flowProcessList.get(0);
        FlowNode flowNode = new FlowNode();
        flowNode.setFlowId(flowProcess.getId());
        List<FlowNode> flowNodeList = getFlowNodeList(flowNode);
        FlowDTO flowDTO = new FlowDTO();
        flowDTO.setFlowProcess(flowProcess);
        flowDTO.setFlowNodeList(flowNodeList);
        return flowDTO;
    }

    @Override
    public FlowDTO getFlowDetail(Long flowId) {
        logger.debug("flowId: {}", flowId);
        FlowProcess flowProcess = flowProcessMapper.selectById(flowId);
        if (flowProcess == null) {
            return null;
        }

        FlowNode flowNode = new FlowNode();
        flowNode.setFlowId(flowId);
        List<FlowNode> flowNodeList = getFlowNodeList(flowNode);

        FlowDTO flowDTO = new FlowDTO();
        flowDTO.setFlowProcess(flowProcess);
        flowDTO.setFlowNodeList(flowNodeList);
        return flowDTO;
    }

    @Override
    public List<FlowDTO> getAllFlowDetail(Long storeId) {
        FlowProcess flowProcessCondition = new FlowProcess();
        flowProcessCondition.setStoreId(storeId);
        flowProcessCondition.setStatus(FlowConstant.FlowProcessStatus.START.code);

        List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcessCondition);
        if (CollectionUtils.isEmpty(flowProcessList)) {
            return null;
        }

        List<FlowDTO> flowDTOList = new ArrayList<>();
        for (FlowProcess flowProcess : flowProcessList) {
            FlowNode flowNode = new FlowNode();
            flowNode.setFlowId(flowProcess.getId());
            List<FlowNode> flowNodeList = getFlowNodeList(flowNode);
            FlowDTO flowDTO = new FlowDTO();
            flowDTO.setFlowProcess(flowProcess);
            flowDTO.setFlowNodeList(flowNodeList);
            flowDTOList.add(flowDTO);
        }

        return flowDTOList;
    }

    @Override
    @Transactional
    public void createFlow(Long mainStoreId, Long childStoreId, Integer storeType) {

        if (FlowConstant.StoreType.isMainStore(storeType)) {//总店添加业务流程
            if (mainStoreId == null) {
                logger.debug("mainStoreId :{}", mainStoreId);
                throw new FlowException("总店ID参数异常");
            }

            if (mainStoreId.intValue() == 0) {
                logger.debug("mainStoreId :{}", mainStoreId);
                throw new FlowException("总店ID参数异常");
            }

            //查询默认配置好的业务流程记录
            FlowProcess flowProcess = new FlowProcess();
            flowProcess.setStoreId(0L);
            List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcess);

            if (CollectionUtils.isEmpty(flowProcessList)) {
                throw new FlowException("默认配置的业务流程不存在");
            }

            for (FlowProcess flow : flowProcessList) {

                // 已经存在流程不添加
                Long flowId = getFlowId(flow.getType(), mainStoreId);
                if (flowId != null) {
                    logger.debug("storeId:{} 已经存在业务流程 flowId: {}", mainStoreId, flowId);
                    continue;
                }

                //插入门店主业务流程
                FlowProcess process = new FlowProcess();
                process.setName(flow.getName());
                process.setType(flow.getType());
                process.setStatus(flow.getStatus());
                process.setDeductStockWay(flow.getDeductStockWay());
                process.setStoreId(mainStoreId);
                process.setCreateTime(new Date());
                int r = flowProcessMapper.insert(process);
                if (r < 1) {
                    logger.debug("mainStoreId :{},process :{}", mainStoreId, process);
                    throw new FlowException("生成门店业务流程失败");
                }

                //查询默认的业务流程各个节点
                FlowNode flowNode = new FlowNode();
                flowNode.setFlowId(flow.getId());
                List<FlowNode> flowNodes = flowNodeMapper.selectByFlowId(flowNode);

                if (CollectionUtils.isEmpty(flowNodes)) {
                    throw new FlowException("默认配置的业务流程节点不存在");
                }
                //生成门店业务流程节点
                Long preNodeId = 0L;
                Long currentNodeId = 0L;
                //Long nextNodeId = 0L;
                for (int i = 0; i < flowNodes.size(); i++) {
                    FlowNode fNode = new FlowNode();
                    fNode.setNodeName(flowNodes.get(i).getNodeName());
                    fNode.setNodeCode(flowNodes.get(i).getNodeCode());
                    fNode.setNodeSeq(flowNodes.get(i).getNodeSeq());

                    if (preNodeId > 0L) {
                        fNode.setPreNode(preNodeId);
                    }

                    if (FlowConstant.NodeCode.isQualityControl(fNode.getNodeCode())) {//质检返工
                        fNode.setFailReturnNode(preNodeId);
                    }

                    fNode.setStatus(flowNodes.get(i).getStatus());//默认开启
                    fNode.setCanClosed(flowNodes.get(i).getCanClosed());
                    fNode.setFlowId(process.getId());
                    fNode.setCreateTime(new Date());
                    int row = flowNodeMapper.insert(fNode);
                    if (row < 1) {
                        logger.debug("mainStoreId :{},flowNode :{}", mainStoreId, fNode);
                        throw new FlowException("生成门店业务流程节点失败");
                    }
                    if (i == 0) {
                        currentNodeId = fNode.getId();
                        preNodeId = currentNodeId;
                    } else {
                        currentNodeId = fNode.getId();
                        //更新上一节点的nextNode
                        FlowNode preNode = new FlowNode();
                        preNode.setId(preNodeId);
                        preNode.setNextNode(currentNodeId);

                        int rr = flowNodeMapper.updateById(preNode);
                        if (rr < 1) {
                            logger.debug("mainStoreId :{},flowNode :{}", mainStoreId, fNode);
                            throw new FlowException("修改门店业务流程上一节点失败");
                        }
                        preNodeId = currentNodeId;
                    }
                }
            }

        } else if (FlowConstant.StoreType.isChildStore(storeType)) {//子店或加盟店添加业务流程
            if (mainStoreId == null || childStoreId == null) {
                logger.debug("mainStoreId :{},childStoreId:{}", mainStoreId, childStoreId);
                throw new FlowException("总店ID参数异常");
            }

            if (mainStoreId.intValue() == 0 || childStoreId.intValue() == 0) {
                logger.debug("mainStoreId :{},childStoreId:{}", mainStoreId, childStoreId);
                throw new FlowException("总店ID或子店ID参数异常");
            }

            //查询总店现有的业务流程
            FlowProcess flowProcess = new FlowProcess();
            flowProcess.setStoreId(mainStoreId);
            List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcess);

            //如果总店的业务流程不存在，则查询默认的业务流程
            if (CollectionUtils.isEmpty(flowProcessList) || flowProcessList.size() != 2) {
                flowProcessList.clear();
                flowProcess.setStoreId(0L);
                flowProcessList = flowProcessMapper.selectBy(flowProcess);
                //throw new FlowException("总店配置的业务流程不存在");
            }

            for (FlowProcess flow : flowProcessList) {
                // 已经存在流程不添加
                Long flowId = getFlowId(flow.getType(), childStoreId);
                if (flowId != null) {
                    logger.debug("childStoreId:{} 已经存在业务流程 flowId: {}", childStoreId, flowId);
                    continue;
                }

                //插入门店主业务流程
                FlowProcess process = new FlowProcess();
                process.setName(flow.getName());
                process.setType(flow.getType());
                process.setStatus(flow.getStatus());
                process.setDeductStockWay(flow.getDeductStockWay());
                process.setStoreId(childStoreId);
                process.setCreateTime(new Date());
                int r = flowProcessMapper.insert(process);
                if (r < 1) {
                    logger.debug("mainStoreId :{},process :{}", mainStoreId, process);
                    throw new FlowException("生成门店业务流程失败");
                }

                //查询默认的业务流程各个节点
                FlowNode flowNode = new FlowNode();
                flowNode.setFlowId(flow.getId());
                List<FlowNode> flowNodes = flowNodeMapper.selectByFlowId(flowNode);

                if (CollectionUtils.isEmpty(flowNodes)) {
                    throw new FlowException("默认配置的业务流程节点不存在");
                }
                //生成门店业务流程节点
                Long preNodeId = 0L;
                Long currentNodeId = 0L;
                for (int i = 0; i < flowNodes.size(); i++) {
                    FlowNode fNode = new FlowNode();
                    fNode.setNodeName(flowNodes.get(i).getNodeName());
                    fNode.setNodeCode(flowNodes.get(i).getNodeCode());
                    fNode.setNodeSeq(flowNodes.get(i).getNodeSeq());

                    if (preNodeId > 0L) {
                        fNode.setPreNode(preNodeId);
                    }

                    if (FlowConstant.NodeCode.isQualityControl(fNode.getNodeCode())) {//质检返工
                        fNode.setFailReturnNode(preNodeId);
                    }

                    fNode.setStatus(flowNodes.get(i).getStatus());//默认开启
                    fNode.setCanClosed(flowNodes.get(i).getCanClosed());
                    fNode.setFlowId(process.getId());
                    fNode.setCreateTime(new Date());
                    int row = flowNodeMapper.insert(fNode);
                    if (row < 1) {
                        logger.debug("mainStoreId :{},flowNode :{}", mainStoreId, fNode);
                        throw new FlowException("生成门店业务流程节点失败");
                    }
                    if (i == 0) {
                        currentNodeId = fNode.getId();
                        preNodeId = currentNodeId;
                    } else {
                        currentNodeId = fNode.getId();
                        //更新上一节点的nextNode字段
                        FlowNode preNode = new FlowNode();
                        preNode.setId(preNodeId);
                        preNode.setNextNode(currentNodeId);

                        int rr = flowNodeMapper.updateById(preNode);
                        if (rr < 1) {
                            logger.debug("mainStoreId :{},flowNode :{}", mainStoreId, fNode);
                            throw new FlowException("修改门店业务流程上一节点失败");
                        }
                        preNodeId = currentNodeId;
                    }
                }
            }
        } else {
            logger.debug("storeType :{}", storeType);
            throw new FlowException("门店类型参数异常");
        }
    }

    @Override
    @Transactional
    public Long updateFlow(FlowDTO flowDTO) {
        FlowProcess flowProcess = flowDTO.getFlowProcess();
        if (flowProcess == null) {
            throw new FlowException("门店业务流程参数异常");
        }

        /* 判断门店所有的订单是否全部支付完成 */
        int count = epOrderMapper.queryNonPayOrder(flowProcess.getStoreId());
        if (count > 0) {
            logger.debug("还有订单未支付不能修改业务流程");
            throw new FlowException("还有订单未支付不能修改业务流程");
        }

        if (flowProcess.getId() == null) {
            logger.debug("flow_id :{ null }");
            throw new FlowException("门店ID参数异常");
        }

        if (flowProcess.getId().intValue() == 0) {
            logger.debug("flow_id :{}", flowProcess.getId());
            throw new FlowException("门店ID参数异常");
        }

        List<FlowNode> flowNodeList = flowDTO.getFlowNodeList();
        if (CollectionUtils.isEmpty(flowNodeList)) {
            throw new FlowException("门店业务流程节点参数异常");
        }

        //根据业务流程ID查询
        FlowProcess flow = flowProcessMapper.selectById(flowProcess.getId());
        if (flow == null) {
            throw new FlowException("门店业务流程不存在");
        }

        FlowNode flowNode = new FlowNode();
        flowNode.setFlowId(flow.getId());
        List<FlowNode> flowNodes = flowNodeMapper.selectByFlowId(flowNode);
        if (CollectionUtils.isEmpty(flowNodes)) {
            throw new FlowException("门店业务流程节点不存在");
        }
        //将原有的记录插入到记录表中
        FlowProcessLog flowProcessLog = new FlowProcessLog();
        flowProcessLog.setProcessId(flow.getId());
        flowProcessLog.setName(flow.getName());
        flowProcessLog.setType(flow.getType());
        flowProcessLog.setStatus(flow.getStatus());
        flowProcessLog.setDeductStockWay(flow.getDeductStockWay());
        flowProcessLog.setStoreId(flow.getStoreId());
        flowProcessLog.setProcessCreateTime(flow.getCreateTime());
        flowProcessLog.setCreateTime(new Date());
        int r = flowProcessLogMapper.insert(flowProcessLog);
        if (r < 1) {
            logger.debug("flowProcessLog :{}", flowProcessLog);
            throw new FlowException("将业务流程插入到日志表异常");
        }
        r = flowProcessMapper.deleteById(flowProcess.getId());
        if (r < 1) {
            logger.debug("flow_id :{}", flowProcess.getId());
            throw new FlowException("删除业务流程表记录异常");
        }

        for (FlowNode node : flowNodes) {
            FlowNodeLog nodeLog = new FlowNodeLog();
            nodeLog.setNodeId(node.getId());
            nodeLog.setNodeName(node.getNodeName());
            nodeLog.setNodeCode(node.getNodeCode());
            nodeLog.setNodeSeq(node.getNodeSeq());
            nodeLog.setPreNode(node.getPreNode());
            nodeLog.setNextNode(node.getNextNode());
            nodeLog.setStatus(node.getStatus());
            nodeLog.setCanClosed(node.getCanClosed());
            nodeLog.setFailReturnNode(node.getFailReturnNode());
            nodeLog.setFlowId(node.getFlowId());
            nodeLog.setNodeCreateTime(node.getCreateTime());
            nodeLog.setCreateTime(new Date());
            r = flowNodeLogMapper.insert(nodeLog);
            if (r < 1) {
                logger.debug("node_id :{}", node.getId());
                throw new FlowException("将业务流程节点插入到日志表异常");
            }
            r = flowNodeMapper.deleteById(node.getId());
            if (r < 1) {
                logger.debug("node_id :{}", node.getId());
                throw new FlowException("删除业务流程节点记录异常");
            }
        }

        //将修改后的业务流程和业务流程节点保存
        flow.setId(null);
        flow.setDeductStockWay(flowProcess.getDeductStockWay());
        flow.setCreateTime(new Date());
        r = flowProcessMapper.insert(flow);
        if (r < 1) {
            logger.debug("flowProcess :{}", flow);
            throw new FlowException("插入新的业务流程记录异常");
        }


        Long preNodeId = 0L;
        Long currentNodeId = 0L;
        for (int i = 0; i < flowNodes.size(); i++) {
            FlowNode newFlowNode = new FlowNode();
            newFlowNode.setNodeName(flowNodes.get(i).getNodeName());
            newFlowNode.setNodeCode(flowNodes.get(i).getNodeCode());
            newFlowNode.setNodeSeq(flowNodes.get(i).getNodeSeq());

            newFlowNode.setCanClosed(flowNodes.get(i).getCanClosed());
            newFlowNode.setFlowId(flow.getId());
            newFlowNode.setCreateTime(new Date());
            if (preNodeId > 0L) {
                newFlowNode.setPreNode(preNodeId);
            }

            if (newFlowNode.getNodeCode().equals(FlowConstant.NodeCode.QUALITY_CONTROL.code)) {//质检返工
                newFlowNode.setFailReturnNode(preNodeId);
            }
            for (FlowNode fNode : flowNodeList) {//页面修改后的node节点
                if (newFlowNode.getNodeCode().equals(fNode.getNodeCode())) {
                    newFlowNode.setStatus(fNode.getStatus());
                }
            }
            int row = flowNodeMapper.insert(newFlowNode);
            if (row < 1) {
                logger.debug("storeId :{},flowNode :{}", flow.getStoreId(), newFlowNode);
                throw new FlowException("生成门店业务流程节点失败");
            }
            if (i == 0) {
                currentNodeId = newFlowNode.getId();
                preNodeId = currentNodeId;
            } else {
                currentNodeId = newFlowNode.getId();
                //更新上一节点的nextNode
                FlowNode node = new FlowNode();
                node.setId(preNodeId);
                node.setNextNode(currentNodeId);

                int rr = flowNodeMapper.updateById(node);
                if (rr < 1) {
                    logger.debug("storeId :{},flowNode :{}", flow.getStoreId(), newFlowNode);
                    throw new FlowException("修改门店业务流程上一节点失败");
                }
                preNodeId = currentNodeId;
            }
        }
        return flow.getId();
    }

    @Override
    public FlowDTO getHistoryFlowDetail(Long flowId) {
        logger.debug("flowId: {}", flowId);
        if (flowId == null) {
            throw new FlowException("业务流程ID参数异常");
        }
        String recordType = "1";
        FlowProcess flowProcess = flowProcessMapper.selectById(flowId);
        if (flowProcess == null) {
            recordType = "2";
            FlowProcessLog flowProcessLog = flowProcessLogMapper.selectByProcessId(flowId);
            if (flowProcessLog == null) {
                throw new FlowException("业务流程不存在");
            } else {
                FlowNodeLog flowNodeLog = new FlowNodeLog();
                flowNodeLog.setFlowId(flowId);
                List<FlowNodeLog> flowNodeLogList = getFlowNodeLogList(flowNodeLog);

                FlowDTO flowDTO = new FlowDTO();
                FlowProcess process = new FlowProcess();
                process.setId(flowProcessLog.getProcessId());
                process.setName(flowProcessLog.getName());
                process.setType(flowProcessLog.getType());
                process.setStatus(flowProcessLog.getStatus());
                process.setDeductStockWay(flowProcessLog.getDeductStockWay());
                process.setStoreId(flowProcessLog.getStoreId());
                process.setCreateTime(flowProcessLog.getCreateTime());
                flowDTO.setFlowProcess(process);

                List<FlowNode> flowNodeList = new ArrayList<>();
                for (FlowNodeLog fNodeLog : flowNodeLogList) {
                    FlowNode node = new FlowNode();
                    node.setId(fNodeLog.getNodeId());
                    node.setNodeName(fNodeLog.getNodeName());
                    node.setNodeCode(fNodeLog.getNodeCode());
                    node.setNodeSeq(fNodeLog.getNodeSeq());
                    node.setPreNode(fNodeLog.getPreNode());
                    node.setNextNode(fNodeLog.getNextNode());
                    node.setStatus(fNodeLog.getStatus());
                    node.setCanClosed(fNodeLog.getCanClosed());
                    node.setFailReturnNode(fNodeLog.getFailReturnNode());
                    node.setFlowId(fNodeLog.getFlowId());
                    node.setCreateTime(fNodeLog.getCreateTime());
                    flowNodeList.add(node);
                }

                flowDTO.setFlowNodeList(flowNodeList);
                return flowDTO;
            }
        } else {
            FlowNode flowNode = new FlowNode();
            flowNode.setFlowId(flowId);
            List<FlowNode> flowNodeList = getFlowNodeList(flowNode);

            FlowDTO flowDTO = new FlowDTO();
            flowDTO.setFlowProcess(flowProcess);
            flowDTO.setFlowNodeList(flowNodeList);
            return flowDTO;
        }
    }

    @Override
    public boolean isDeductStockWhenGet(Long flowId) {
        if (flowId == null) {
            throw new FlowException("业务流程ID参数异常");
        }
        FlowProcess flowProcess = flowProcessMapper.selectById(flowId);
        if (flowProcess == null) {
            FlowProcessLog flowProcessLog = flowProcessLogMapper.selectById(flowId);
            if (flowProcessLog == null) {
                throw new FlowException("业务流程不存在");
            } else {
                return FlowConstant.DeductStockWay.isWhenGet(flowProcessLog.getDeductStockWay());
            }
        } else {
            return FlowConstant.DeductStockWay.isWhenGet(flowProcess.getDeductStockWay());
        }
    }

    @Override
    public boolean isDeductStockWhenPay(Long flowId) {
        if (flowId == null) {
            throw new FlowException("业务流程ID参数异常");
        }
        FlowProcess flowProcess = flowProcessMapper.selectById(flowId);
        if (flowProcess == null) {
            FlowProcessLog flowProcessLog = flowProcessLogMapper.selectById(flowId);
            if (flowProcessLog == null) {
                throw new FlowException("业务流程不存在");
            } else {
                return FlowConstant.DeductStockWay.isWhenPay(flowProcessLog.getDeductStockWay());
            }
        } else {
            return FlowConstant.DeductStockWay.isWhenPay(flowProcess.getDeductStockWay());
        }
    }

    @Override
    public Long getFlowId(Integer flowType, Long storeId) {
        FlowProcess flowProcessCondition = new FlowProcess();
        flowProcessCondition.setType(flowType);
        flowProcessCondition.setStoreId(storeId);
        flowProcessCondition.setStatus(FlowConstant.FlowProcessStatus.START.code);

        List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcessCondition);
        if (CollectionUtils.isEmpty(flowProcessList)) {
            return null;
        } else {
            return flowProcessList.get(0).getId();
        }
    }

    @Override
    public boolean validNodeStatus(Long storeId, Integer flowType, String nodeCode) {
        logger.debug("storeId: {},flowType:{},nodeCode:{}", storeId, flowType, nodeCode);
        FlowProcess flowProcess = new FlowProcess();
        flowProcess.setType(flowType);
        flowProcess.setStoreId(storeId);
        flowProcess.setStatus(FlowConstant.FlowProcessStatus.START.code);
        List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcess);

        if (CollectionUtils.isEmpty(flowProcessList) || flowProcessList.size() > 1) {
            throw new FlowException("业务流程不存在或有多个异常");
        } else {
            return isStartNode(flowProcessList.get(0).getId(), nodeCode);
        }
    }

    @Override
    public boolean validNodeStatus(Long flowId, String nodeCode) {
        FlowProcess flowProcess = flowProcessMapper.selectById(flowId);
        if (flowProcess == null) {
            FlowProcessLog flowProcessLog = flowProcessLogMapper.selectById(flowId);
            if (flowProcessLog == null) {
                throw new FlowException("业务流程不存在");
            } else {
                return isStartNodeLog(flowProcessLog.getId(), nodeCode);
            }
        } else {
            return isStartNode(flowProcess.getId(), nodeCode);
        }
    }

    /**
     * 从流程日志表判断流程节点的状态
     * @param flowId
     * @param nodeCode
     * @return
     */
    private boolean isStartNodeLog(Long flowId, String nodeCode) {
        FlowNodeLog flowNodeLog = new FlowNodeLog();
        flowNodeLog.setFlowId(flowId);
        flowNodeLog.setNodeCode(nodeCode);
        FlowNodeLog fNodeLog = flowNodeLogMapper.selectByFlowIdAndNodeCode(flowNodeLog);
        if (fNodeLog == null) {
            throw new FlowException("业务流程节点不存在");
        }
        return FlowConstant.NodeStatus.isStart(fNodeLog.getStatus());
    }

    /**
     * 从流程主表判断流程节点的状态
     * @param flowId
     * @param nodeCode
     * @return
     */
    private boolean isStartNode(Long flowId, String nodeCode) {
        FlowNode flowNode = new FlowNode();
        flowNode.setFlowId(flowId);
        flowNode.setNodeCode(nodeCode);
        FlowNode fNode = flowNodeMapper.selectByFlowIdAndNodeCode(flowNode);
        if (fNode == null) {
            throw new FlowException("业务流程节点不存在");
        }
        return FlowConstant.NodeStatus.isStart(fNode.getStatus());
    }

    @Override
    public boolean isOutDeductStock(Long storeId, Integer flowType) {
        logger.debug("storeId: {},flowType:{}", storeId, flowType);
        FlowProcess flowProcess = new FlowProcess();
        flowProcess.setType(flowType);
        flowProcess.setStoreId(storeId);
        flowProcess.setStatus(FlowConstant.FlowProcessStatus.START.code);
        List<FlowProcess> flowProcessList = flowProcessMapper.selectBy(flowProcess);
        if (CollectionUtils.isEmpty(flowProcessList)) {
            return false;
        } else {
            return FlowConstant.DeductStockWay.isWhenGet(flowProcessList.get(0).getDeductStockWay());
        }
    }

    private List<FlowNode> getFlowNodeList(FlowNode flowNode) {
        if (flowNode == null) {
            throw new FlowException("查询业务节点参数异常");
        }
        List<FlowNode> flowNodeList = flowNodeMapper.selectByFlowId(flowNode);
        if (CollectionUtils.isEmpty(flowNodeList)) {
            throw new FlowException("业务流程节点不存在");
        }
        return flowNodeList;
    }

    private List<FlowNodeLog> getFlowNodeLogList(FlowNodeLog flowNodeLog) {
        if (flowNodeLog == null) {
            throw new FlowException("查询历史业务节点参数异常");
        }
        List<FlowNodeLog> flowNodeLogList = flowNodeLogMapper.selectByFlowId(flowNodeLog);
        if (CollectionUtils.isEmpty(flowNodeLogList)) {
            throw new FlowException("历史业务流程节点不存在");
        }
        return flowNodeLogList;
    }

}
