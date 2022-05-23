package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/21/2022
    Time: 2:45 PM
**/
@Configuration
@EnableWebMvc
@ComponentScan({"com.example.web.controller.statust","com.example.requestMapping"})
public class MvcConfig implements WebMvcConfigurer {
    public MvcConfig(){
        super();
    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        final Jackson2ObjectMapperBuilder builder=new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true).dateFormat(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
