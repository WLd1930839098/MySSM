package com.bins.service;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;

public interface BookService {

    PageInfo<BookStoreItem> findAll(String name,int currentPage);
}
