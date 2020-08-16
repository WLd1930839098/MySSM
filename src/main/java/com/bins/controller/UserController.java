package com.bins.controller;

import com.bins.bean.PageInfo;
import com.bins.bean.Role;
import com.bins.bean.User;
import com.bins.service.RoleService;
import com.bins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")        //加不加“/"都可以
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("login.do")
    //username，password需要和jsp文件内input标签内的name属性相同
    public ModelAndView login(String name,String password,HttpSession session){

        User user = userService.login(name,password);
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){
            session.setAttribute("user",user);
            modelAndView.setViewName("main");
        }else{
            modelAndView.setViewName("../failer");
        }
        return modelAndView;
    }

    @RequestMapping("findAllUsers.do")
    public ModelAndView findAllUsers(String name, @RequestParam(defaultValue = "1") int currentPage,
                                @RequestParam(defaultValue = "0") int type,HttpSession session){
        if(type==1){
            //将搜索的字符串再次传递到前端,以便在搜索结果中使用换页功能
            session.setAttribute("sn",name);
        }else if(type==2){
            //当搜索完毕之后接着点击侧边栏的用户管理界面（这时我们想要查询全部）
            // 若不删除sn，由于之前存在sn（上一次的搜索名字）
            //显示的结果任然是上次的搜索结果
            session.removeAttribute("sn");
        }
        else {
            name = (String)session.getAttribute("sn");
        }

        //方法名无所谓可以随便写
        PageInfo<User> pageInfo = userService.findAll(name,currentPage);
        ModelAndView modelAndView = new ModelAndView();
        //将数据绑定到视图解析器
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");
        //modeAndView.addObject("sn",username);
        return modelAndView;
    }

    @RequestMapping("addRole.do")
    @ResponseBody           //保证返回的数据是json字符串
    public String addRole(String roleList,String userId){
        String[] roleIds = roleList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String tmp:roleIds){
            ids.add(Integer.parseInt(tmp));
        }
        roleService.addRoleToUser(ids,Integer.parseInt(userId));
        return "ok";
    }

    @RequestMapping("deleteUserById.do")
    public String deleteUserById(int id){
        userService.deleteById(id);
        return "redirect:findAllUsers.do";
    }

    @RequestMapping("deleteUserByIds.do")
    @ResponseBody
    public String deleteUserByIds(String userIdList){
        String[] userIds = userIdList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String tmp:userIds){
            ids.add(Integer.parseInt(tmp));
        }
        userService.deleteByIds(ids);
        return "ok";
    }

    @RequestMapping("addUser.do")
    public String addUser(User user){
        userService.add(user);
        return "redirect:findAllUsers.do";
    }

    @RequestMapping("toUpdateUser.do")
    public ModelAndView toUpdate(int id){
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-update");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("updateUser.do")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:findAllUsers.do";
    }

    @RequestMapping("toAddRoleToUser.do")
    public ModelAndView toAddRole(int id){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-role-add");
        modelAndView.addObject("id",id);

        List<Role> roles = roleService.findNoRoles(id);
        modelAndView.addObject("roles",roles);
        return modelAndView;
    }



}