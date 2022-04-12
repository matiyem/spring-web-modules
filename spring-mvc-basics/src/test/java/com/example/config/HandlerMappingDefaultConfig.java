package com.example.config;

import com.example.web.controller.handlerMapping.BeanNameHandlerMappingController;
import com.example.web.controller.handlerMapping.WelcomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HandlerMappingDefaultConfig {

    @Bean("/welcome")
    public BeanNameHandlerMappingController beanNameHandlerMapping() {
        return new BeanNameHandlerMappingController();
    }

    @Bean
    public WelcomeController welcomeDefaultMappingConfig() {
        return new WelcomeController();
    }

}