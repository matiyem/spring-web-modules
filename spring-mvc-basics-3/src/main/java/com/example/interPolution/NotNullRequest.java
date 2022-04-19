package com.example.interPolution;

import lombok.Data;

import javax.validation.constraints.NotNull;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:49 PM
**/
@Data
public class NotNullRequest {

    @NotNull(message = "stringValue has to be present")
    private String stringValue;

}
