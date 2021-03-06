package com.example.controller.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:11 PM
**/
public class StudentControllerConfig //implements WebApplicationInitializer
{

    //uncomment to run the student controller example
    //@Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(WebConfig.class);
        root.setServletContext(sc);
        sc.addListener(new ContextLoaderListener(root));

        DispatcherServlet dv = new DispatcherServlet(root);

        ServletRegistration.Dynamic appServlet = sc.addServlet("test-mvc", dv);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/test/*");
    }
}
