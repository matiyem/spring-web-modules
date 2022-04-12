package com.example.web.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/11/2022
    Time: 10:41 AM
**/
@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/example",method = RequestMethod.GET)
    public User fetchUserExample(@RequestParam(value = "firstName")String firstName){
        return userService.fetchUserByFirstName(firstName);
    }
}
