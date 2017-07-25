package com.epoint.reception.service;

import com.epoint.reception.dto.ReceptionDetailDTO;
import com.epoint.reception.entity.AppReceptionList;
import com.epoint.reception.vo.AppReceptionListVo;

import java.util.List;
import java.util.Map;

/**
 * @author xishengchun on 2017-05-24.
 */
public interface IReceptionService {


    /**
     * 查询接车详情
     * @param receptionId
     * @return
     */
    ReceptionDetailDTO getReceptionDetail(Long receptionId);

    /**
     * 查询没开单的接车信息
     * @param memberId
     * @return
     */
    AppReceptionList getNoOrderReception(Long memberId);

    /**
     * 查询接车基本信息
     * @param receptionId
     * @return
     */
    AppReceptionList getReception(Long receptionId);

    List<AppReceptionListVo> queryTodayReceptionList(Map<String, Object> map);

}
