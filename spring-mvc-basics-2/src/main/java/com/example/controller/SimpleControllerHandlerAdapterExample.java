package com.example.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 11:06 AM
 **/
public class SimpleControllerHandlerAdapterExample extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView model=new ModelAndView("Greeting");
        model.addObject("message","Dinesh Madhwal");
        return null;
    }
}
