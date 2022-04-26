package com.example.contexts.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 11:23 AM
**/
public class AnnotationsBasedApplicationInitializer //extends AbstractContextLoaderInitializer
{
    //uncomment to run the multiple contexts example
    // @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootApplicationConfig.class);
        return rootContext;
    }

}
