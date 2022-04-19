package com.example.interPolution;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:50 PM
**/
@RestController
public class ValidationController {

    @PostMapping("/test-not-null")
    public void testNotNull(@Valid @RequestBody NotNullRequest request) {

    }
}
