package com.example.optionalPathVars;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 2:50 PM
**/
public class Article {
    public static final Article DEFAULT_ARTICLE = new Article(12);

    private Integer id;

    public Article(Integer articleId) {
        this.id = articleId;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Article [id=" + id + "]";
    }
}
