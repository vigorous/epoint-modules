package com.epoint.book.dao;

import com.epoint.book.dto.BookInfoPageQueryBean;
import com.epoint.book.dto.BookInfoQueryBean;
import com.epoint.book.entity.BookInfo;
import org.junit.Test;
import spring.test.BeanTest;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/5/19.
 */
public class BookInfoDaoTest extends BeanTest {
    @Resource
    private BookInfoMapper bookInfoMapper;

    @Test
    public void testSelectByBookDate(){
        bookInfoMapper.selectByBookDate(-1L,"2017-05-19");
    }

    @Test
    public void testSelectByMemberId(){
        bookInfoMapper.selectByMemberId(-1L);
    }

    @Test
    public void testSelectByPate(){
        BookInfoPageQueryBean bookInfoPageQueryBean = new BookInfoPageQueryBean();
        bookInfoPageQueryBean.setStoreId(1L);
        bookInfoPageQueryBean.setRows(20);
        bookInfoPageQueryBean.setStartRowNo(0);
        bookInfoPageQueryBean.setConditionType(1);
        bookInfoPageQueryBean.setCondition("浙A");
        bookInfoMapper.selectByPage(bookInfoPageQueryBean);
    }

    @Test
    public void testSelectCount(){
        BookInfoQueryBean bookInfoPageQueryBean = new BookInfoQueryBean();
        bookInfoPageQueryBean.setStoreId(1L);

        bookInfoPageQueryBean.setConditionType(1);
        bookInfoPageQueryBean.setCondition("浙A");
        bookInfoPageQueryBean.setBookDateEnd("2017-05-31");
        Integer r = bookInfoMapper.selectCount(bookInfoPageQueryBean);

        System.out.println("**************" + r);
    }


    @Test
    public void testSelectCountByCarNo(){
        BookInfo bookInfo = new BookInfo();
        bookInfo.setStoreId(1L);
        bookInfo.setCarNo("浙A");
        bookInfo.setBookDate("2017-05-31");
        Integer r = bookInfoMapper.selectCountByCarNo(bookInfo);
        System.out.println("**************" + r);
    }
}
