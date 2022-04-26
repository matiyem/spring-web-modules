package com.example.optionalPathVars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:32 AM
**/
@RestController
@RequestMapping(value = "/requiredAttribute")
public class ArticleViewerWithRequiredAttributeController {
    @RequestMapping(value = {"/article","/article/{id}"})
    public Article getArticle(@PathVariable(name = "id",required = false)Integer articleId){
        if (articleId !=null){
            return new Article(articleId);
        }else {
            return Article.DEFAULT_ARTICLE;
        }
    }
}
