package com.epoint.flow.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.flow.entity.FlowProcessLog;

import java.util.List;

public interface FlowProcessLogMapper extends BaseMapper<FlowProcessLog> {

    /**
     * 根据业务流程ID查询历史业务流程记录
     * @param processId 业务流程ID
     * @return FlowProcessLog
     */
    FlowProcessLog selectByProcessId(Long processId);

    /**
     * 根据条件查询业务流程日志记录
     * @param flowProcessLog
     * @return List<FlowProcessLog>
     */
    List<FlowProcessLog> selectByCondition(FlowProcessLog flowProcessLog);
}