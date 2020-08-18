package com.bins.controller;

import com.bins.bean.Borrow;
import com.bins.bean.PageInfo;
import com.bins.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(String name, @RequestParam(defaultValue = "1")int currentPage){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Borrow> pageInfo = borrowService.findAll(name,currentPage);
        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("borrow-list");
        return modelAndView;
    }

    @RequestMapping("borrowBook.do")
    public String borrowBook(int userId,int bookNameId){

        borrowService.borrow(userId,bookNameId);
        return "redirect:/book/findAll.do";
    }

    @RequestMapping("returnBook.do")
    public String returnBook(int userId,int bookId){
        borrowService.returnBook(userId,bookId);
        return "redirect:/borrow/findAll.do";
    }
}
