package com.example.web.controller.statust;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 11:28 AM
**/
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "To show an example of a custom message")
public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 6826605655586311552L;

}
