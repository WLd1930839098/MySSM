package com.bins.controller;

import com.bins.bean.BookStoreItem;
import com.bins.bean.PageInfo;
import com.bins.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


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

    @RequestMapping("addBook.do")
    public String addBook(String name,int sum){
        //name:添加的书名,
        //sum:要添加的总数。
        bookService.add(name,sum);

        return "redirect:/book/findAll.do";
    }

    @RequestMapping("deleteByBookNameId.do")
    @ResponseBody
    public String deleteBooksByBookNameId(int[] ids){
        List<Integer> bookNameIdList = new ArrayList<>();
        for(int i:ids)
            bookNameIdList.add(i);
        bookService.deleteByBookNameIds(bookNameIdList);

        return "ok";
    }
}
