package com.bins.service;

import com.bins.bean.Borrow;
import com.bins.bean.PageInfo;

public interface BorrowService {
    PageInfo<Borrow> findAll(String name,int currentPage);

    void borrow(int userId, int bookNameId);

    void returnBook(int userId, int bookId);
}
