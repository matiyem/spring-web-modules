package com.example.compress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 2:25 PM
**/
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add(new CompressingClientHttpRequestInterceptor());
        return restTemplate;
    }
}
