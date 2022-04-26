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
    Time: 11:34 AM
**/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.contexts.normal"})
public class NormalWebAppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
