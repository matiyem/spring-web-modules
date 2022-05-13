package com.example.sampleApp.config;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 1:22 PM
*/

import com.example.sampleApp.interceptor.RestTemplateHeaderModifierInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestClientConfig {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors=restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)){
            interceptors=new ArrayList<ClientHttpRequestInterceptor>();
        }
        interceptors.add(new RestTemplateHeaderModifierInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}