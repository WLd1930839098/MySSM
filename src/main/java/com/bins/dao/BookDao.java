package com.bins.dao;

import com.bins.bean.BookStoreItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    List<BookStoreItem> findAll(@Param("name")String name,@Param("start")int start);

    int getCount(@Param("name")String name);

    Integer findBookNameId(@Param("name")String name);

    int findNextBookNameId();

    void addBookName(@Param("bookNameId")int bookNameId,@Param("bookName")String bookName);

    void addBook(@Param("bookNameId")int bookNameId);

    void deleteBookByBookNameIds(@Param("ids")List<Integer> ids);

    int findFreeBookIdByNameId(@Param("nameId")int bookNameId);

    void setBookBorrowed(@Param("bookId")int bookId);

    void setBookReturned(@Param("bookId")int bookId);
}
