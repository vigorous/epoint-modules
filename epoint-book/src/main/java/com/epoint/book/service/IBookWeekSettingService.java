package com.epoint.book.service;

import com.epoint.book.entity.BookWeekSetting;

/**
 * Created by chiang on 2017/5/20.
 */
public interface IBookWeekSettingService {
    BookWeekSetting queryWeekSettingByStoreId(Long storeId);
}
