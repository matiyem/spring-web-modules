package com.example.web.controller.statust;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 11:17 AM
**/
@Controller
public class ExampleController {
    @RequestMapping(value = "/controller", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity sendViaException() {
        throw new ForbiddenException();
    }
}
