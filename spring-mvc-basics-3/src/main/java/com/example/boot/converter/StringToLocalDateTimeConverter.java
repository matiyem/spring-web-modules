package com.example.boot.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:11 AM
**/
@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(final String source) {
        return LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
