package com.example.exception;

import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/*
    Create by Atiye Mousavi 
    Date: 5/1/2022
    Time: 10:12 AM
**/
@RestController
@ControllerAdvice
public class HttpMediaTypeNotAcceptableExceptionExampleController {
    @PostMapping(value = "/test",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public Map<String,String> test(){
        return Collections.singletonMap("key","value");
    }
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException(){
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;

    }
}
