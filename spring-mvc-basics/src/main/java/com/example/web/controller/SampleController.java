package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    Create by Atiye Mousavi 
    Date: 4/11/2022
    Time: 9:55 AM
**/
@Controller
public class SampleController {
    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }

    @GetMapping("/sample2")
    public String showForm2() {
        return "sample2";
    }

    @GetMapping("/sample3")
    public String showForm3() {
        return "sample3";
    }
}
