package com.example.sampleApp.web.controller.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/*
    Create by Atiye Mousavi 
    Date: 5/16/2022
    Time: 10:20 AM
**/
@Controller
@RequestMapping("/")
public class RedirectParamController {

    @RequestMapping(value = "/forwardedWithParams", method = RequestMethod.GET)
    public RedirectView forwardedWithParams(final RedirectAttributes redirectAttributes, HttpServletRequest request) {

        redirectAttributes.addAttribute("param1", request.getAttribute("param1"));
        redirectAttributes.addAttribute("param2", request.getAttribute("param2"));

        redirectAttributes.addAttribute("attribute", "forwardedWithParams");
        return new RedirectView("redirectedUrl");

    }
}