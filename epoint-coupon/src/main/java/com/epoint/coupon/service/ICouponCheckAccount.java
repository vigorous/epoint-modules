package com.epoint.coupon.service;

import com.epoint.coupon.dto.CouponCheckAccountDTO;
import com.epoint.store.entity.Store;

import java.util.List;
import java.util.Map;

/**
 * Created by yyy on 2017/4/19.
 */
public interface ICouponCheckAccount {
    /**
     * 对账应收总数查询
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */

    int queryReceivableNumByPage(Map<String,Object> map);
    /**
     * 对账应收列表查询
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<CouponCheckAccountDTO> queryReceivableListByPage(Map<String,Object> map);

    /**
     * 对账应付总数查询
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */

    int queryPayableNumByPage(Map<String,Object> map);

    /**
     * 对账应付列表查询
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<CouponCheckAccountDTO> queryPayableListByPage(Map<String,Object> map);

    /**
     *对账应收 领取门店列表
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<Store> queryReceivableStoreList(Map<String,Object> map);

    /**
     * 对账应付 使用门店列表
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<Store> queryPayableStoreList(Map<String,Object> map);


    /**
     *对账应收 小计
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<CouponCheckAccountDTO> querySumReceivableCount(Map<String,Object> map);

    /**
     *对账应付 小计
     * @param map("storeId",Long)必须包含storeId key
     * @return
     */
    List<CouponCheckAccountDTO> querySumPayableCount(Map<String,Object> map);


}
