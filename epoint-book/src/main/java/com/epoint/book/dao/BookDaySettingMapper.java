package com.epoint.book.dao;

import com.epoint.book.entity.BookDaySetting;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDaySettingMapper extends BaseMapper<BookDaySetting> {
    /**
     * 查某一天的预约设置信息
     * @param storeId 门店ID
     * @param bookDate 格式如:2017-05-18
     * @return 预约设置
     */
    BookDaySetting selectByBookDate(@Param("storeId") Long storeId,@Param("bookDate") String bookDate);

    /**
     * 查询某一个月的预约设置
     * @param storeId 门店ID
     * @param bookDate 预约日期格式:2017-05
     * @return 预约设置列表
     */
    List<BookDaySetting> selectByMonth(@Param("storeId") Long storeId,@Param("bookDate") String bookDate);

    /**
     * 按天更新预约设置信息
     * @param bookDaySetting
     * @return
     */
    int updateByBookDate(BookDaySetting bookDaySetting);

    /**
     * 按周几更新最大预约人数
     * @param bookDaySetting
     * @return
     */
    int updateByWeek(BookDaySetting bookDaySetting);
}