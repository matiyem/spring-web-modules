package com.example.optionalPathVars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 2:53 PM
**/
public class ArticleViewerController {
    @RequestMapping(value = {"/article", "/article/{id}"})
    public Article getArticle(@PathVariable(name = "id") Integer articleId) {
        if (articleId != null) {
            return new Article(articleId);
        } else {
            return Article.DEFAULT_ARTICLE;
        }
    }
}
