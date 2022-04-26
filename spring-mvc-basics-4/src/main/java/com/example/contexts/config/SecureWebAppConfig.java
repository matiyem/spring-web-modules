package com.example.contexts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 12:03 PM
**/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.contexts.services"})
public class SecureWebAppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/secure/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
