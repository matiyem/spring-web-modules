package com.example.flash_attributes.model;

import org.apache.logging.log4j.util.Strings;
import lombok.Data;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:00 PM
**/
@Data
public class Poem {
    private String title;
    private String author;
    private String body;

    public static boolean isValidPoem(Poem poem){
        return poem != null && Strings.isNotBlank(poem.getAuthor()) && Strings.isNotBlank(poem.getBody())
                && Strings.isNotBlank(poem.getTitle());
    }
}
