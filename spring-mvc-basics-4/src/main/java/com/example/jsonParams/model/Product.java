package com.example.jsonParams.model;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 2:27 PM
**/
public class Product {

    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
