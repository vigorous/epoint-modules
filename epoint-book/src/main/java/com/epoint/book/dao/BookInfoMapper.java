package com.epoint.book.dao;

import com.epoint.book.dto.BookInfoPageQueryBean;
import com.epoint.book.dto.BookInfoQueryBean;
import com.epoint.book.entity.BookInfo;
import com.epoint.dao.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoMapper extends BaseMapper<BookInfo> {
    List<BookInfo> selectByBookDate(@Param("storeId") Long storeId, @Param("bookDate") String bookDate);

    List<BookInfo> selectByMemberId(@Param("memberId") Long memberId);

    List<BookInfo> selectByPage(BookInfoPageQueryBean query);

    Integer selectCount(BookInfoQueryBean query);

    /**
     * 预约校验用
     * 查询一辆车在同一个店同一天预约的次数
     * @return
     */
    Integer selectCountByCarNo(BookInfo bookInfo);

}