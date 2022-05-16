package com.example.resttemplate.logging.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 3:09 PM
**/
@RestController
public class PersonController {

    @PostMapping("/persons")
    public List<String> getPersons(){
        return Arrays.asList(new String[] { "Lucie", "Jackie", "Danesh", "Tao" });
    }
}
