package com.bins.service.impl;

import com.bins.bean.PageInfo;
import com.bins.bean.Role;
import com.bins.bean.UserRole;
import com.bins.dao.RoleDao;
import com.bins.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;


    @Override
    public PageInfo<Role> findAll(int currentPage) {
        PageInfo<Role> pageInfo = new PageInfo<>();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setSize(5);
        int start = (currentPage-1)*pageInfo.getSize();
        pageInfo.setList(roleDao.findAll(start));
        int count = roleDao.getCount();
        pageInfo.setTotalCount(count);
        int totalPage = (int)Math.ceil((double)count/pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }

    @Override
    public List<Role> findNoRoles(int id) {
        return roleDao.findNoRolesByUserId(id);
    }

    @Override
    public void addRoleToUser(List<Integer> ids, int userId) {
        UserRole userRole = new UserRole();
        for(int tmp:ids){
            userRole.setRoleId(tmp);
            userRole.setUserId(userId);
            roleDao.addRoleToUser(userRole);
        }
    }

    @Override
    public void deleteById(int id) {

        roleDao.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        roleDao.deleteByIds(ids);
    }

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }
}