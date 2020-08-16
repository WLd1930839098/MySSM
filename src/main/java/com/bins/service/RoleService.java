package com.bins.service;

import com.bins.bean.PageInfo;
import com.bins.bean.Role;

import java.util.List;

public interface RoleService {

    Role findById(int id);

    PageInfo<Role> findAll(int currentPage);

    List<Role> findNoRoles(int id);

    void addRoleToUser(List<Integer> ids, int userId);

    void deleteById(int id);

    void deleteByIds(List<Integer> ids);

    void update(Role role);

    void add(Role role);

}