package com.example.resttemplateException.controller;

import com.example.resttemplateException.model.Criterion;
import com.example.resttemplateException.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/16/2022
    Time: 9:50 AM
**/
@RestController
@RequestMapping("/api")
public class ProductApi {
    private List<Product> productList = new ArrayList<>(Arrays.asList(new Product(1, "Acer Aspire 5", 437), new Product(2, "ASUS VivoBook", 650), new Product(3, "Lenovo Legion", 990)));

    @GetMapping("/get")
    public Product get(@RequestParam String critertion) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        Criterion crt=objectMapper.readValue(critertion,Criterion.class);
        if (crt.getProp().equals("name"))
            return findByName(crt.getValue());
        return null;
    }
    private Product findByName(String name) {
        for (Product product : this.productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
