package com.example.jsonParams.controller;

import com.example.jsonParams.model.Product;
import com.example.jsonParams.propertyEditor.ProductEditor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 2:24 PM
**/
@Controller
@RequestMapping("/products")
public class ProductController {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Product.class,new ProductEditor(objectMapper));
    }

    @PostMapping("/create")
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return product;
    }

    @GetMapping("/get2")
    @ResponseBody
    public Product get2Product(@RequestParam Product product){
        return product;
    }

}
