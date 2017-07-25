package com.epoint.book.dao;
import com.epoint.book.entity.BookDaySetting;
import com.epoint.book.entity.BookWeekSetting;
import org.junit.Assert;
import org.junit.Test;
import spring.test.BeanTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by chiang on 2017/5/18.
 */
public class BookSettingDaoTest extends BeanTest{
    @Resource
    private BookDaySettingMapper bookDaySettingMapper;

    @Resource
    private BookWeekSettingMapper bookWeekSettingMapper;

    @Test
    public void testQueryBookWeekSetting(){
        BookWeekSetting bookWeekSetting = bookWeekSettingMapper.selectByStoreId(1L);
    }

    @Test
    public void testQueryBookDaySetting(){
        BookDaySetting bookDaySetting = bookDaySettingMapper.selectByBookDate(1L,"2017-05-18");
    }

    @Test
    public void testQueryBookDaySettingByMonth(){
        List<BookDaySetting> bookDaySettingList = bookDaySettingMapper.selectByMonth(1L,"2017-05");
    }

    @Test
    public void testUpdateDaySetting(){
        BookDaySetting bookDaySetting = new BookDaySetting();
        bookDaySetting.setStoreId(-1L);
        bookDaySetting.setBookDate("2017-05-18");
        bookDaySetting.setMaxNum(100);
        bookDaySetting.setUpdateTime(new Date());
        int r = bookDaySettingMapper.updateByBookDate(bookDaySetting);
        Assert.assertEquals(r,0);
    }

    @Test
    public void testUpdateSettingByStoreId(){
        BookWeekSetting bookWeekSetting = new BookWeekSetting();
        bookWeekSetting.setStoreId(-1L);
        bookWeekSetting.setUpdateTime(new Date());
        bookWeekSetting.setDay1(10);
        int r = bookWeekSettingMapper.updateByStoreId(bookWeekSetting);
        Assert.assertEquals(r,0);
    }


    @Test
    public void testUpdateDaySettingByWeek(){
        BookDaySetting bookDaySetting = new BookDaySetting();
        bookDaySetting.setStoreId(-1L);
        bookDaySetting.setBookDate("2017-05-18");
        bookDaySetting.setMaxNum(100);
        bookDaySetting.setUpdateTime(new Date());
        int r = bookDaySettingMapper.updateByWeek(bookDaySetting);
        Assert.assertEquals(r,0);
    }
}
