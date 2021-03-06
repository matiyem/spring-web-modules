package com.example.jsonParams.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:45 PM
**/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.jsonParams"})
public class JsonParamsConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver bean=new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        return bean;
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
