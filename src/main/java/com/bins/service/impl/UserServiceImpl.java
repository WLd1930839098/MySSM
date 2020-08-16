package com.bins.service.impl;

import com.bins.bean.PageInfo;
import com.bins.bean.User;
import com.bins.dao.RoleDao;
import com.bins.dao.UserDao;
import com.bins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service            //使Autowired注解能够找到
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.findByName(username);
        boolean flag = (user!=null&&user.getPassword().equals(password));
        if(flag){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public PageInfo<User> findAll(String searchName, int currentPage) {
        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setSize(5);
        int start = (currentPage-1)*pageInfo.getSize();
        pageInfo.setList(userDao.findAll(searchName,start));
        int count = userDao.getCount(searchName);
        pageInfo.setTotalCount(count);
        int totalPage = (int)Math.ceil((double)count/pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        roleDao.deleteUserRoleByUserIds(ids);
        userDao.deleteByIds(ids);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

}