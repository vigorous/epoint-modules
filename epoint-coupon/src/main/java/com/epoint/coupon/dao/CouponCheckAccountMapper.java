package com.epoint.coupon.dao;

import com.epoint.coupon.dto.CouponCheckAccountDTO;
import com.epoint.dao.Mapper;
import com.epoint.store.entity.Store;

import java.util.List;
import java.util.Map;

/**
 * Created by yyy on 2017/4/19.
 */
public interface CouponCheckAccountMapper extends Mapper{

    /**
     * 对账应收总数查询
     * @param map
     * @return
     */

    int queryReceivableNumByPage(Map<String,Object> map);
    /**
     * 对账应收列表查询
     * @param map
     * @return
     */
    List<CouponCheckAccountDTO> queryReceivableListByPage(Map<String,Object> map);

    /**
     * 对账应付总数查询
     * @param map
     * @return
     */

    int queryPayableNumByPage(Map<String,Object> map);

    /**
     * 对账应付列表查询
     * @param map
     * @return
     */
    List<CouponCheckAccountDTO> queryPayableListByPage(Map<String,Object> map);

    /**
     *对账应收 领取门店列表
     * @param map
     * @return
     */
    List<Store> queryReceivableStoreList(Map<String,Object> map);

    /**
     * 对账应付 使用门店列表
     * @param map
     * @return
     */
    List<Store> queryPayableStoreList(Map<String,Object> map);

    /**
     *对账应收 小计
     * @param map
     * @return
     */
    List<CouponCheckAccountDTO> querySumReceivableCount(Map<String,Object> map);

    /**
     *对账应付 小计
     * @param map
     * @return
     */
    List<CouponCheckAccountDTO> querySumPayableCount(Map<String,Object> map);
}
