package com.example.validation.listValidation.constraint;

import com.example.validation.listValidation.model.Movie;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:47 AM
**/
public class MaxSizeConstraintValidator implements ConstraintValidator<MaxSizeConstraint, List<Movie>> {
    @Override
    public boolean isValid(List<Movie> movies, ConstraintValidatorContext constraintValidatorContext) {
        return movies.size() <= 4;
    }
}
