package com.example.validator;

import com.example.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 11:04 AM
 **/
@Component
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"customerId","error.customerId","Customer Id is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"customerName","error.customerName","Customer Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"customerContact","error.customerNumber","Customer Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"customerEmail","error.customerEmail","Customer Email is required");

    }
}
