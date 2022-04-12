package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 12:24 PM
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;


}
