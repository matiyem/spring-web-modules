package com.example.jsonParams.propertyEditor;

import com.example.jsonParams.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 2:36 PM
**/
public class ProductEditor extends PropertyEditorSupport {

    private ObjectMapper objectMapper;

    public ProductEditor(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)){
            setValue(null);
        }else {
            Product prod=new Product();

            try {
                prod=objectMapper.readValue(text,Product.class);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
            setValue(prod);
        }
    }
}
