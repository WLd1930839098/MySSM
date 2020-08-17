package com.bins.service;

import com.bins.bean.Borrow;
import com.bins.bean.PageInfo;

public interface BorrowService {
    PageInfo<Borrow> findAll(String name,int currentPage);
}
