package com.bins.dao;

import com.bins.bean.BookStoreItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookStoreDao {
    List<BookStoreItem> findAll(@Param("name")String name,@Param("start")int start);

    int getCount(@Param("name")String name);
}
