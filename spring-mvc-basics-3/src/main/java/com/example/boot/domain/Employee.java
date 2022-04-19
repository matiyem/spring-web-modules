package com.example.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
    Create by Atiye Mousavi 
    Date: 4/16/2022
    Time: 2:11 PM
**/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private long id;
    private double salary;
}
