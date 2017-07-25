package com.epoint.book.service.impl;

import com.epoint.book.dao.BookWeekSettingMapper;
import com.epoint.book.entity.BookWeekSetting;
import com.epoint.book.service.IBookWeekSettingService;
import com.epoint.book.utils.ClassUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by chiang on 2017/5/20.
 */
@Component
public class BookWeekSettingService implements IBookWeekSettingService {
    private final static org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(BookWeekSettingService.class.getName());

    @Resource
    private BookWeekSettingMapper bookWeekSettingMapper;

    @Override
    public BookWeekSetting queryWeekSettingByStoreId(Long storeId) {
        BookWeekSetting bookWeekSetting = bookWeekSettingMapper.selectByStoreId(storeId);
        if (bookWeekSetting != null) {
           return bookWeekSetting;
        }
        bookWeekSetting = new BookWeekSetting();
        bookWeekSetting.setStoreId(storeId);
        bookWeekSetting.setCreateTime(new Date());
        bookWeekSetting.setUpdateTime(bookWeekSetting.getCreateTime());
        for (int i = 1; i <= 7; i++) {
            try {
                ClassUtils.invokeSetMethod(bookWeekSetting, "day" + i, -1);
            } catch (Exception e) {
                LOGGER.error("设置最大预约人数错误", e);
            }
        }
        int r = bookWeekSettingMapper.insert(bookWeekSetting);
        LOGGER.debug("storeId insert week setting r:{}", storeId, r);
        return bookWeekSetting;
    }
}
