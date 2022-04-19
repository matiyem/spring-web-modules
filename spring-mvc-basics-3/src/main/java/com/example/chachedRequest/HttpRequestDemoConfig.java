package com.example.chachedRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:46 AM
**/
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example.chachedRequest")
public class HttpRequestDemoConfig implements WebMvcConfigurer {
}
