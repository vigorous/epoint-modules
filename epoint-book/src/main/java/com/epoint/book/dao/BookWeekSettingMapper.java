package com.epoint.book.dao;

import com.epoint.book.entity.BookWeekSetting;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface BookWeekSettingMapper extends BaseMapper<BookWeekSetting> {
   BookWeekSetting selectByStoreId(@Param("storeId") Long storeId);

   int updateByStoreId(BookWeekSetting bookWeekSetting);
}