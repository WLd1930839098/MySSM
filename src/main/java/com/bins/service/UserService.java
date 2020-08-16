package com.bins.service;

import com.bins.bean.PageInfo;
import com.bins.bean.User;

import java.util.List;

public interface UserService {

    User login(String username,String password);

    User findById(int id);

    PageInfo<User> findAll(String searchName, int currentPage);

    void deleteById(int id);

    void deleteByIds(List<Integer> ids);

    void add(User user);

    void update(User user);

}