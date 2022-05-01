package com.example.customValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 4/27/2022
    Time: 2:44 PM
**/
@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint {

    String message() default "Invalid phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
