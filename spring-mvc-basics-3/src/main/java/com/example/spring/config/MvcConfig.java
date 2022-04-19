package com.example.spring.config;

import com.example.boot.converter.StringToEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:54 PM
**/
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    public MvcConfig(){
        super();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }
}
