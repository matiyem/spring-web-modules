package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 12:09 PM
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;
    private String author;
    private String title;
}
