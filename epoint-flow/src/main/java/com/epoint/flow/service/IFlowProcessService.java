package com.epoint.flow.service;

import com.epoint.flow.dto.FlowDTO;


/**
 * @author xishengchun on 2017-05-18.
 */
public interface IFlowProcessService {

    /**
     * 获取流程详情
     *
     * @param flowType 流程类型
     * @param storeId  门店
     * @return
     */
    FlowDTO getFlowDetail(Integer flowType, Long storeId);

    /**
     * 获取流程详情
     *
     * @param flowId 流程id
     * @return
     */
    FlowDTO getFlowDetail(Long flowId);

    /**
     * 获取门店所有正在使用的业务流程
     *
     * @param storeId 门店ID
     * @return List<FlowDTO>
     */
    List<FlowDTO> getAllFlowDetail(Long storeId);

    /**
     * 新增业务流程
     * 1.如果创建的是总店业务流程（mainStoreId有值，storeType = 1）
     * 2.如果创建的是子店或者加盟店业务流程（mainStoreId，childStoreId都有值，storeType = 2）
     *
     * @param mainStoreId  总店ID
     * @param childStoreId 子店或加盟店ID
     * @param storeType    门店类型（1-代表总店，2-代表子店或者加盟店）
     * @Exception FlowException
     */
    void createFlow(Long mainStoreId, Long childStoreId, Integer storeType);

    /**
     * 修改业务流程以及业务流程节点
     * flowDTO其中属性：flowProcess,flowNodeList
     * flowProcess必传字段 ：id,deduct_stock_way
     * flowNodeList必传字段 ：node_code,status,
     *
     * @param flowDTO
     * @return 返回新的流程id
     * @Exception FlowException
     */
    Long updateFlow(FlowDTO flowDTO);

    /**
     * 根据流程ID查询该流程的详细信息
     * <p>
     * 适用用于 --> 订单绑定的流程ID , 查询历史业务流程
     *
     * @param flowId 流程业务id
     * @return
     * @Exception FlowException
     */
    FlowDTO getHistoryFlowDetail(Long flowId);

    /**
     * 根据业务流程ID判断是否是出库扣库存方式
     *
     * @param flowId 业务流程ID
     * @return
     * @Exception FlowException
     */
    boolean isDeductStockWhenGet(Long flowId);

    /**
     * 根据业务流程ID判断是否是支付扣库存方式
     *
     * @param flowId 业务流程ID
     * @return
     * @Exception FlowException
     */
    boolean isDeductStockWhenPay(Long flowId);

    /**
     * 根据门店ID、业务流程类型查询当前正在使用的业务流程ID
     * <p>
     * 注：
     * 1. 订单绑定业务流程ID时用到
     * 2. 返回值可以为null
     *
     * @param flowType 业务流程类型
     * @param storeId  门店ID
     * @return
     */
    Long getFlowId(Integer flowType, Long storeId);

    /**
     * 判断门店正在使用的业务流程节点状态开启还是关闭
     * 查询当前流程的节点状态
     * @param storeId  门店ID
     * @param flowType 业务流程类型
     * @param nodeCode 流程节点编码
     * @return boolean (true - 开启，false - 关闭)
     * @Exception FlowException
     */
    boolean validNodeStatus(Long storeId, Integer flowType, String nodeCode);


    /**
     * 根据流程id,判断节点状态.
     * 如果主流程表没有,则判断流程日志表数据
     * @param flowId 门店流程id
     * @param nodeCode 流程节点编码
     * @see com.epoint.flow.enums.FlowConstant.NodeCode
     * @return boolean (true - 开启，false - 关闭)
     * @Exception FlowException
     */
    boolean validNodeStatus(Long flowId, String nodeCode);

    /**
     * 根据门店ID、流程类型查询是否是出库减库存
     * @param storeId 门店ID
     * @param flowType 流程类型
     * @return boolean (true - 出库减库存，false - 结算自动减库存)
     */
    boolean isOutDeductStock(Long storeId, Integer flowType);

}
