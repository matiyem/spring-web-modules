package com.example.boot.web.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Create by Atiye Mousavi 
    Date: 4/13/2022
    Time: 2:47 PM
**/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Version {
}
