package com.bins.controller;

import com.bins.bean.PageInfo;
import com.bins.bean.Role;
import com.bins.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("findAllRoles.do")
    public ModelAndView findAllRole(@RequestParam(defaultValue = "1")int currentPage){

        PageInfo<Role> pageInfo = roleService.findAll(currentPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("deleteRoleById.do")
    public String delete(int id){
        roleService.deleteById(id);
        return "redirect:findAllRoles.do";
    }

    @RequestMapping("deleteRoleByIds.do")
    @ResponseBody
    public String deleteRoleByIds(String roleIdList){
        String[] roleIds = roleIdList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String tmp:roleIds){
            ids.add(Integer.parseInt(tmp));
        }
        roleService.deleteByIds(ids);

        return "";
    }

    @RequestMapping("toUpdateRole.do")
    public ModelAndView toUpdateRole(int id){
        Role role = roleService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-update");
        return modelAndView;
    }

    @RequestMapping("updateRole.do")
    public String updateRole(Role role){
        roleService.update(role);
        return "redirect:findAllRoles.do";
    }

    @RequestMapping("addRole.do")
    public String addRole(Role role){
        roleService.add(role);
        return "redirect:findAllRoles.do";
    }
}
