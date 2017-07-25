package com.epoint.book.service.impl;


import com.epoint.book.dao.BookTagMapper;
import com.epoint.book.entity.BookTag;
import com.epoint.book.service.IBookTagService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BookTagService implements IBookTagService {
    private final static org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(BookTagService.class.getName());

    @Resource
    private BookTagMapper bookTagMapper;


    @Override
    public List<BookTag> queryAll(Long storeId) {
        List<BookTag> bookTagList = bookTagMapper.queryByStoreId(storeId);
        if (CollectionUtils.isEmpty(bookTagList)){
            List<BookTag>  tagList = bookTagMapper.queryByStoreId(0L);
//            Date now = new Date();
//            tagList.forEach(item->{
//                BookTag tag = new BookTag();
//                tag.setName(item.getName());
//                tag.setStoreId(storeId);
//                tag.setCreateTime(now);
//                tag.setUpdateTime(now);
//                tag.setId(null);
//                bookTagMapper.insert(tag);
//            });
           // bookTagList = bookTagMapper.queryByStoreId(storeId);

            return tagList;
        }

        return bookTagList;
    }
}
