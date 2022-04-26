package com.example.contexts.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 12:52 PM
**/
@Service(value = "contextAware")
public class ApplicationContextUtilService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
