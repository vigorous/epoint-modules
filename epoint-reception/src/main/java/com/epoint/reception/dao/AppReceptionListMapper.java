package com.epoint.reception.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.reception.entity.AppReceptionList;
import com.epoint.reception.vo.AppReceptionListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppReceptionListMapper extends BaseMapper<AppReceptionList> {
    /**
     * 根据车牌号,会员Id和门店Id查询接车单
     *
     * @param map
     * @return
     */
    AppReceptionList queryByMemberIdAndCarNo(Map map);

    /**
     * 根据车牌号,会员Id和门店Id,today?("0":"1")查询接车单
     *
     * @param map
     * @return
     */
    List<AppReceptionList> queryReceptionList(Map<String, Object> map);

    /**
     * 根据条件分页查询接车单
     *
     * @param map
     * @return List<AppReceptionList>
     */
    List<AppReceptionList> queryListByPage(Map map);

    /**
     * 根据条件查询接车单总数
     *
     * @param map
     * @return int
     */
    int queryNumByPage(Map map);


    AppReceptionList selectNoOrderReception(@Param("memberId") Long memberId);

    /*
        APP日结统计今日接车
     */
    List<AppReceptionListVo> queryTodayReceptionList(Map<String, Object> map);

    int updateReceptionCheckId(@Param("receptionId") Long receptionId,@Param("checkId") Long checkId);
}