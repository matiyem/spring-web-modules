package com.example.config;

import com.example.web.controller.handlerMapping.WelcomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Configuration
public class BeanNameUrlHandlerMappingConfig {

    @Bean
    BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean("/beanNameUrl")
    public WelcomeController welcomeBeanNameMappingConfig() {
        return new WelcomeController();
    }

}
