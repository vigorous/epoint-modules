package com.epoint.flow.entity;

import com.epoint.entity.BaseEntity;
import java.util.Date;

/**
 * 表名:erp_flow_node_log
 */
public class FlowNodeLog extends BaseEntity {
    private Long id;

    /**
     * 节点ID
     */
    private Long nodeId;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 节点编码
     */
    private String nodeCode;

    /**
     * 节点顺序
     */
    private Integer nodeSeq;

    /**
     * 上个节点
     */
    private Long preNode;

    /**
     * 下个节点
     */
    private Long nextNode;

    /**
     * 状态：0-关闭，1-开启
     */
    private Integer status;

    /**
     * 是否可关闭：0-不可关闭，1-可关闭
     */
    private Integer canClosed;

    /**
     * 返工节点
     */
    private Long failReturnNode;

    /**
     * 业务流程ID
     */
    private Long flowId;

    /**
     * 节点创建时间
     */
    private Date nodeCreateTime;

    /**
     * 节点修改时间
     */
    private Date nodeUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public Integer getNodeSeq() {
        return nodeSeq;
    }

    public void setNodeSeq(Integer nodeSeq) {
        this.nodeSeq = nodeSeq;
    }

    public Long getPreNode() {
        return preNode;
    }

    public void setPreNode(Long preNode) {
        this.preNode = preNode;
    }

    public Long getNextNode() {
        return nextNode;
    }

    public void setNextNode(Long nextNode) {
        this.nextNode = nextNode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCanClosed() {
        return canClosed;
    }

    public void setCanClosed(Integer canClosed) {
        this.canClosed = canClosed;
    }

    public Long getFailReturnNode() {
        return failReturnNode;
    }

    public void setFailReturnNode(Long failReturnNode) {
        this.failReturnNode = failReturnNode;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public Date getNodeCreateTime() {
        return nodeCreateTime;
    }

    public void setNodeCreateTime(Date nodeCreateTime) {
        this.nodeCreateTime = nodeCreateTime;
    }

    public Date getNodeUpdateTime() {
        return nodeUpdateTime;
    }

    public void setNodeUpdateTime(Date nodeUpdateTime) {
        this.nodeUpdateTime = nodeUpdateTime;
    }
}