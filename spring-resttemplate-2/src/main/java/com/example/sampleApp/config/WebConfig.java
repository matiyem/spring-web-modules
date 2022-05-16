package com.example.sampleApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    Create by Atiye Mousavi 
    Date: 5/16/2022
    Time: 10:04 AM
**/
@Configuration
@EnableWebMvc
@ComponentScan({ "com.example.sampleApp.web" })
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        super();
    }

}