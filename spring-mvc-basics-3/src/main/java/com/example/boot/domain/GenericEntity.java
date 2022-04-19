package com.example.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 10:48 AM
**/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    public GenericEntity(String value) {
        this.value = value;
    }


}
