package com.example.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:42 PM
**/
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public ModelAndView getTestData(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        mv.getModel().put("data", "Welcome home man");

        return mv;
    }
}
