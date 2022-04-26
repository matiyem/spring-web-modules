package com.example.validation.listValidation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.html.parser.Entity;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 11:03 AM
**/
@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append("\n" + violation.getMessage()));
            errorMessage = builder.toString();
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }

        logger.error(errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
