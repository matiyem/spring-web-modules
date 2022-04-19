package com.example.boot.config;

import com.example.boot.converter.GenericBigDecimalConverter;
import com.example.boot.converter.StringToAbstractEntityConverterFactory;
import com.example.boot.converter.StringToEmployeeConverter;
import com.example.boot.converter.StringToEnumConverter;
import com.example.boot.web.resolver.HeaderVersionArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 4/13/2022
    Time: 2:33 PM
**/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new HeaderVersionArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEmployeeConverter());
        registry.addConverter(new StringToEnumConverter());
        registry.addConverterFactory(new StringToAbstractEntityConverterFactory());
        registry.addConverter(new GenericBigDecimalConverter());
    }
}
