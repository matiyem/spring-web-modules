package com.example.optionalPathVars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:40 AM
**/
@RestController
@RequestMapping(value = "/seperateMethods")
public class ArticleViewerWithTwoSeparateMethodsController {

    @RequestMapping(value = "/article/{id}")
    public Article getArticle(@PathVariable(name = "id")Integer articleId){
       return new Article(articleId);
    }
    @RequestMapping(value = "/article")
    public Article getDefaultArticle(){
        return Article.DEFAULT_ARTICLE;
    }
}
