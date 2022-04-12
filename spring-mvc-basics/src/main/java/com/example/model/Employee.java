package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 12:22 PM
**/
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;
    private String name;
    private String contactNumber;
    private String workingArea;

}
