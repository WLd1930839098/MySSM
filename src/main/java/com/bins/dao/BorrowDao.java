package com.bins.dao;

import com.bins.bean.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowDao {
    List<Borrow> findAll(@Param("name")String name,@Param("start") int start);

    int getCount(@Param("name")String name);

    void borrowBook(@Param("userId")int userId,@Param("bookId") int bookId);

    void returnBook(@Param("userId")int userId, @Param("bookId")int bookId);
}
