package com.example.contexts.normal;

import com.example.contexts.services.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 12:42 PM
**/
@Controller
public class HelloWorldController {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private GreeterService greeterService;

    private void processContext(){
        WebApplicationContext rootContext= ContextLoader.getCurrentWebApplicationContext();

        System.out.println("root context :"+rootContext);
        System.out.println("root context Beans: "+ Arrays.asList(rootContext.getBeanDefinitionNames()));

        System.out.println("context :"+ webApplicationContext);
        System.out.println("context Beans: "+Arrays.asList(webApplicationContext));
    }
    @RequestMapping(path = "/welcome")
    public ModelAndView helloWorld(){
        processContext();
        String message = "<br><div style='text-align:center;'>" + "<h3>Normal " + greeterService.greet() + "</h3></div>";
        return new ModelAndView("welcome","message",message);
    }
}
