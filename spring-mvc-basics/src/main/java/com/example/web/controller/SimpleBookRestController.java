package com.example.web.controller;

import com.example.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/11/2022
    Time: 10:16 AM
**/
@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    public Book getBook(@PathVariable int id){
        return findBookById(id);
    }
    private Book findBookById(int id){
        Book book=null;
        if (id==42){
            book=new Book();
            book.setId(id);
            book.setAuthor("Douglas Adamas");
            book.setTitle("Hitchhiker's guide to the galaxy");
        }
        return book;
    }
}
