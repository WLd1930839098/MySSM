package com.bins.service.impl;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;
import com.bins.dao.BookStoreDao;
import com.bins.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookStoreDao bookStoreDao;

    @Override
    public PageInfo<BookStoreItem> findAll(String name,int currentPage){
        PageInfo<BookStoreItem> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setSize(5);
        int start = (currentPage-1)*pageInfo.getSize();
        pageInfo.setList(bookStoreDao.findAll(name,start));
        int count = bookStoreDao.getCount(name);
        pageInfo.setTotalCount(count);
        int totalPage = (int)Math.ceil((double)count/pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }
}
