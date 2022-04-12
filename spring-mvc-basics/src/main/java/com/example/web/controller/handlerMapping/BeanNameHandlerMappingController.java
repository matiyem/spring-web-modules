package com.example.web.controller.handlerMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 1:35 PM
**/
public class BeanNameHandlerMappingController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model=new ModelAndView("bean-name-handler-mapping");
        return model;
    }
}
