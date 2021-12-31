package com.example.controller.rss;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 9:08 AM
 **/
@Data
public class Article implements Serializable {

    private String link;
    private String title;
    private String description;
    private Date publishedDate;
    private String author;
    @Override
    public String toString() {
        return "Article{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", author='" + author + '\'' +
                '}';
    }
}
