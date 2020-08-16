package com.bins.dao;

import com.bins.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User findByName(String name);

    User findById(int id);

    List<User> findAll(@Param("searchName")String searchName,@Param("start")int start);

    void deleteById(int id);

    void deleteByIds(@Param("ids")List<Integer>ids);

    void add(User user);

    void update(User user);



    int getCount(@Param("searchName")String searchName);
}