package com.bins.controller;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;
import com.bins.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(String name, @RequestParam(defaultValue = "1")int currentPage){

        ModelAndView modelAndView = new ModelAndView();
        PageInfo<BookStoreItem> pageInfo = bookService.findAll(name,currentPage);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("book-list");

        return modelAndView;
    }
}
