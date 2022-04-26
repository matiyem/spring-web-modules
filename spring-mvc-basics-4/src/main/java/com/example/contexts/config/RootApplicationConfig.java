package com.example.contexts.config;

import com.example.contexts.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 11:54 AM
**/
@Configuration
@ComponentScan(basePackages = {"com.example.contexts.services"})
public class RootApplicationConfig {

    @Bean
    public Greeting greeting(){
        Greeting greeting=new Greeting();
        greeting.setMessage("Hello World !!");
        return greeting;
    }
}
