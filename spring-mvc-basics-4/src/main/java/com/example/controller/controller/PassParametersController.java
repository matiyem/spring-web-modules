package com.example.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:28 PM
**/
@Controller
public class PassParametersController {

    @GetMapping("/showViewPage")
    public String passParametersWithModel(Model model){
        model.addAttribute("message","Baeldung");
        return "viewPage";
    }
    @GetMapping("/printViewPage")
    public String passParametersWithModelMap(ModelMap map){
        map.addAttribute("welcomeMessage","welcome");
        map.addAttribute("message","Baeldung");
        return "viewPage";
    }
    @GetMapping("/goToViewPage")
    public ModelAndView passParametersWithModelAndView(){
        ModelAndView modelAndView = new ModelAndView("viewPage");
        modelAndView.addObject("message", "Baeldung");
        return modelAndView;
    }
}
