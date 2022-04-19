package com.example.boot.converter;

import com.example.boot.domain.Employee;
import org.springframework.core.convert.converter.Converter;


/*
    Create by Atiye Mousavi 
    Date: 4/16/2022
    Time: 2:10 PM
**/
public class StringToEmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String source) {
        String[] data=source.split(",");
        return new Employee(Long.parseLong(data[0]),Double.parseDouble(data[1]));

    }
}
