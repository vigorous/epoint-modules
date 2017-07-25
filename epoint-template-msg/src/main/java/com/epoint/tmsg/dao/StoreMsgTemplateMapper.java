package com.epoint.tmsg.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.tmsg.dto.StoreMsgTemplateDto;
import com.epoint.tmsg.entity.StoreMsgTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMsgTemplateMapper extends BaseMapper<StoreMsgTemplate> {
    List<StoreMsgTemplate> selectByStoreId(@Param("storeId") Long storeId);

    StoreMsgTemplate selectByStoreIdAndShortTemplateId(@Param("storeId") Long storeId,@Param("templateIdShort")String templateIdShort);


    /**
     * 连接查询(查询门店开启的模版)
     * @param storeId
     * @return
     */
    List<StoreMsgTemplateDto> joinSelectByStoreId(@Param("storeId") Long storeId);
}