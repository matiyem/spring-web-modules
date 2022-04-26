package com.example.contexts.services;

import com.example.contexts.Greeting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 12:43 PM
**/
@Service
public class GreeterService {

    @Resource
    private Greeting greeting;

    public String greet(){
        return greeting.getMessage();
    }
}
