package com.example.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
    Create by Atiye Mousavi 
    Date: 4/27/2022
    Time: 2:41 PM
**/
public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint,String> {
    @Override
    public void initialize(ContactNumberConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value !=null && value.matches("[0-9]+") && (value.length()>8) &&(value.length()<14);
    }
}
