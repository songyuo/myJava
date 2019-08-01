package org.sang.controller;

import org.sang.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
//@RestController  //可以代替@Controller和@ResponseBody注解
@Controller
public class BookController {
    @GetMapping("/book")
    @ResponseBody
    public Book book(){
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(39f);
        book.setPublicationDate(new Date());
        return book;
    }
}
