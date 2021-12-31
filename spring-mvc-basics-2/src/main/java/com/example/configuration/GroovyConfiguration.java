package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.groovy.GroovyMarkupConfigurer;
import org.springframework.web.servlet.view.groovy.GroovyMarkupViewResolver;

/**
 * created by Atiye Mousavi
 * Date: 11/26/2021
 * Time: 4:56 PM
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example.springmvcforms", "com.example.controller", "com.example.validator" })
public class GroovyConfiguration {
    //برای کانفیگ template groovy است

    @Bean
    public GroovyMarkupConfigurer groovyMarkupConfigurer(){
        GroovyMarkupConfigurer configurer=new GroovyMarkupConfigurer();
        configurer.setResourceLoaderPath("/WEB-INF/views/");
        return configurer;
    }
    @Bean
    public GroovyMarkupViewResolver groovyMarkupViewResolver(){
        GroovyMarkupViewResolver viewResolver=new GroovyMarkupViewResolver();
        viewResolver.setSuffix(".tpl");
        return viewResolver;
    }
}
