package com.example.boot.converter;

import com.example.boot.domain.Modes;

import org.springframework.core.convert.converter.Converter;

/*
    Create by Atiye Mousavi 
    Date: 4/16/2022
    Time: 2:35 PM
**/
public class StringToEnumConverter implements Converter<String, Modes> {
    @Override
    public Modes convert(String source) {
        return Modes.valueOf(source);
    }
}
