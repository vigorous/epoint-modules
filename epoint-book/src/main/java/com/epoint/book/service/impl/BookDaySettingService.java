package com.epoint.book.service.impl;

import com.epoint.book.dao.BookDaySettingMapper;
import com.epoint.book.entity.BookDaySetting;
import com.epoint.book.entity.BookWeekSetting;
import com.epoint.book.enums.BookSettingConstant;
import com.epoint.book.service.IBookDaySettingService;
import com.epoint.book.utils.ClassUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

;

/**
 * Created by chiang on 2017/5/20.
 */
@Component
public class BookDaySettingService implements IBookDaySettingService{

    private final static org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(BookDaySettingService.class.getName());

    private static  final  List<Integer> MONTH_MAX_DAYS_LIST = new ArrayList<>();
    static {

        MONTH_MAX_DAYS_LIST.add(31);//1
        MONTH_MAX_DAYS_LIST.add(28);//2
        MONTH_MAX_DAYS_LIST.add(31);//3
        MONTH_MAX_DAYS_LIST.add(30);//4
        MONTH_MAX_DAYS_LIST.add(31);//5
        MONTH_MAX_DAYS_LIST.add(30);//6
        MONTH_MAX_DAYS_LIST.add(31);//7
        MONTH_MAX_DAYS_LIST.add(31);//8
        MONTH_MAX_DAYS_LIST.add(30);//9
        MONTH_MAX_DAYS_LIST.add(31);//10
        MONTH_MAX_DAYS_LIST.add(30);//11
        MONTH_MAX_DAYS_LIST.add(31);//12
    }
    @Resource
    private BookDaySettingMapper bookDaySettingMapper;



    @Override
    public void initDaySetting(BookWeekSetting bookWeekSetting, int year, int month) {
        Long storeId = bookWeekSetting.getStoreId();
        int maxDays = MONTH_MAX_DAYS_LIST.get(month - 1);
        LOGGER.debug("year:{} month:{} days:{}",year,month,maxDays);
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            maxDays++;
        }
        final int max = maxDays;

        BookDaySetting daySetting = new BookDaySetting();
        daySetting.setCreateTime(new Date());
        daySetting.setUpdateTime(daySetting.getCreateTime());
        daySetting.setStoreId(storeId);
        IntStream.range(1, max + 1).forEach(i->{
            Integer maxBookNum = -1;
            LocalDate bookDate = LocalDate.of(year,month,i);

            int week = bookDate.getDayOfWeek().getValue();
            if (week == 7){
                week = 1;
            } else {
                week = week + 1;
            }
            try {
                maxBookNum = ClassUtils.invokeGetMethod(bookWeekSetting,"day"+week);
            } catch (Exception e){
                LOGGER.error("获取最多预约人数错误",e);
            }

            daySetting.setId(null);
            daySetting.setBookDate(bookDate.toString());
            daySetting.setMaxNum(maxBookNum);
            daySetting.setActMaxNum(0);
            daySetting.setWeek(week);
            daySetting.setIsWeek(BookSettingConstant.IsWeek.YES.getCode());
            int r = bookDaySettingMapper.insert(daySetting);
            LOGGER.debug("storeId:{} insert day setting r:{}", storeId, r);
        });


    }


}
