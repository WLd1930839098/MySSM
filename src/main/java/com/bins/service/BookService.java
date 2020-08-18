package com.bins.service;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;

import java.util.List;

public interface BookService {

    PageInfo<BookStoreItem> findAll(String name,int currentPage);

    void add(String name,int sum);

    void deleteByBookNameIds(List<Integer> ids);
}
