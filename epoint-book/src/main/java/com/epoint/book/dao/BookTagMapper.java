package com.epoint.book.dao;

import com.epoint.book.entity.BookTag;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookTagMapper extends BaseMapper<BookTag> {
    List<BookTag> queryByStoreId(@Param("storeId") Long storeId);
}