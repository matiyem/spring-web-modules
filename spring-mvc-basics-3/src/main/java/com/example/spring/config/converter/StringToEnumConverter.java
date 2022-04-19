package com.example.spring.config.converter;

import com.example.boot.domain.Modes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:53 PM
**/
@Component
public class StringToEnumConverter implements Converter<String, Modes> {
    @Override
    public Modes convert(String source) {
        try {
            return Modes.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }    }
}
