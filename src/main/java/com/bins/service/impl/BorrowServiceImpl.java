package com.bins.service.impl;

import com.bins.bean.Borrow;
import com.bins.bean.PageInfo;
import com.bins.dao.BookDao;
import com.bins.dao.BorrowDao;
import com.bins.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public PageInfo<Borrow> findAll(String name,int currentPage) {
        PageInfo<Borrow> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setSize(5);
        int start = (currentPage-1)*pageInfo.getSize();
        pageInfo.setList(borrowDao.findAll(name,start));
        int count = borrowDao.getCount(name);
        pageInfo.setTotalCount(count);
        int totalPage = (int)Math.ceil((double)count/pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }

    @Override
    @Transactional
    public void borrow(int userId, int bookNameId) {
        int bookId = bookDao.findFreeBookIdByNameId(bookNameId);
        bookDao.setBookBorrowed(bookId);
        borrowDao.borrowBook(userId,bookId);
    }

    @Override
    @Transactional
    public void returnBook(int userId, int bookId) {
        borrowDao.returnBook(userId,bookId);
        bookDao.setBookReturned(bookId);
    }
}
