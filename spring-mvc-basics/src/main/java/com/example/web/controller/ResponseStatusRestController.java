package com.example.web.controller;

import com.example.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/*
    Create by Atiye Mousavi 
    Date: 4/11/2022
    Time: 9:49 AM
**/
@RestController
public class ResponseStatusRestController {

    @GetMapping("/teapot")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void teapot(){

    }
    @GetMapping("empty")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void emptyResponse(){

    }
    @GetMapping("empty-no-responsestatus")
    public void emptyResponseWithoutResponseStatus(){

    }
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createEntity(){
        int randomInt= ThreadLocalRandom.current().nextInt(1,100);
        Book entity = new Book(randomInt, "author" + randomInt, "title" + randomInt);
        return entity;
    }
    @PostMapping("create-no-responsestatus")
    public Book createEntityWithoutResponseStatus() {
        // here we would create and persist an entity
        int randomInt = ThreadLocalRandom.current()
                .nextInt(1, 100);
        Book entity = new Book(randomInt, "author" + randomInt, "title" + randomInt);
        return entity;
    }
}
