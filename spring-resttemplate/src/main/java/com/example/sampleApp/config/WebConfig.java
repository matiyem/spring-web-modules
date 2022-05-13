package com.example.sampleApp.config;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 1:18 PM
*/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"com.example.sampleApp.web"})
public class WebConfig implements WebMvcConfigurer {
    public WebConfig() {
        super();
    }

}
