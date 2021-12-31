package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 10:56 AM
 **/
@Controller
public class AnnotationMethodHandlerAdapterExample {

    @RequestMapping("/annotation")
    public ModelAndView getEmployeeName(){
        ModelAndView model=new ModelAndView("Greeting");
        model.addObject("message","Dinesh");
        return model;
    }
}
