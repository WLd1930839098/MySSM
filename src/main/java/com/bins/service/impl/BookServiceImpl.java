package com.bins.service.impl;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;
import com.bins.dao.BookDao;
import com.bins.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public PageInfo<BookStoreItem> findAll(String name,int currentPage){
        PageInfo<BookStoreItem> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setSize(5);
        int start = (currentPage-1)*pageInfo.getSize();
        pageInfo.setList(bookDao.findAll(name,start));
        int count = bookDao.getCount(name);
        pageInfo.setTotalCount(count);
        int totalPage = (int)Math.ceil((double)count/pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }

    @Override
    @Transactional
    public void add(String name, int sum) {
        Integer bookNameId = bookDao.findBookNameId(name);

        if(bookNameId==null){
            int nameId = bookDao.findNextBookNameId();
            bookDao.addBookName(nameId,name);
            for(int i=0;i<sum;i++)
                bookDao.addBook(nameId);
        }else{
            for(int i=0;i<sum;i++)
                bookDao.addBook(bookNameId);
        }
    }

    @Override
    public void deleteByBookNameIds(List<Integer> ids) {
        bookDao.deleteBookByBookNameIds(ids);
    }
}
