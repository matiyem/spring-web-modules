package com.example.optionalPathVars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:12 AM
**/
@RestController
@RequestMapping("/optionalParam")
public class ArticleViewerWithOptionalParamController {
    @RequestMapping(value = {"/article","/article/{id}"})
    public Article getArticle(@PathVariable(name = "id")Optional<Integer> optionalArticleId){
        if (optionalArticleId.isPresent()){
            Integer articleId=optionalArticleId.get();
            return new Article(articleId);
        }else {
            return Article.DEFAULT_ARTICLE;
        }
    }
}
