package com.epoint.book.service;
import com.epoint.book.entity.BookTag;
import java.util.List;

public interface IBookTagService {
    List<BookTag> queryAll(Long storeId);
}
