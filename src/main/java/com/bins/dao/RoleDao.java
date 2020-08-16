package com.bins.dao;

import com.bins.bean.Role;
import com.bins.bean.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<Role> findAll(@Param("start")int start);

    Role findById(int id);

    List<Role> findNoRolesByUserId(int id);

    void addRoleToUser(UserRole userRole);

    void deleteUserRoleByUserIds(@Param("ids")List<Integer> userIds);

    void add(Role role);

    void deleteById(int id);

    void deleteByIds(@Param("ids")List<Integer> ids);

    void update(Role role);

    int getCount();
}