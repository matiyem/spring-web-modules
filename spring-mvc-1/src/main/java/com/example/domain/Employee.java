package com.example.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 12:13 PM
 **/
@Data
public class Employee {
    private long id;

    @NotNull
    @Size(min=5)
    private String name;

    @NotNull
    @Size(min = 7)
    private String contactNumber;
}
