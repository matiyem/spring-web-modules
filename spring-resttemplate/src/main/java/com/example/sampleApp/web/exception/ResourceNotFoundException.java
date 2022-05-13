package com.example.sampleApp.web.exception;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 3:27 PM
*/


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
