package com.example.web.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Create by Atiye Mousavi 
    Date: 4/11/2022
    Time: 10:23 AM
**/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/example",method = RequestMethod.GET)
    @ResponseBody
    public User fetchUserExample(){
        return userService.exampleUser();
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET)
    @ResponseBody
    public User fetchUserByFirstName(@RequestParam(value = "firstName") String firstNsme){
        return userService.fetchUserByFirstName(firstNsme);
    }
}
