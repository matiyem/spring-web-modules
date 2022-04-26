package com.example.validation.listValidation.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:44 AM
**/
@Constraint(validatedBy = MaxSizeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxSizeConstraint {
    String message() default "The input list cannot contain more than 4 movies.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
