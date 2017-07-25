package com.epoint.book.service;

import com.epoint.book.dao.BookWeekSettingMapper;
import com.epoint.book.entity.BookWeekSetting;
import org.junit.Test;
import spring.test.BeanTest;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/5/22.
 */
public class BookSettingServiceTest  extends BeanTest {
    @Resource
    private IBookDaySettingService bookDaySettingService;

    @Resource
    private BookWeekSettingMapper bookWeekSettingMapper;

    @Test
    public void testInit(){
        BookWeekSetting weekSetting = bookWeekSettingMapper.selectByStoreId(1L);

        bookDaySettingService.initDaySetting(weekSetting,2017,5);
    }
}
