package com.example.requesttimeout.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * created by Atiye Mousavi
 * Date: 9/21/2021
 * Time: 12:01 PM
 */

@Entity
@Data
public class Book {
    @Id
    private String title;
    private String author;

}
