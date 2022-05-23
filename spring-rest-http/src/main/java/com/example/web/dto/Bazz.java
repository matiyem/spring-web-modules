package com.example.web.dto;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:08 AM
**/
public class Bazz {
    public String id;
    public String name;

    public Bazz(String id){
        this.id = id;
    }
    public Bazz(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bazz [id=" + id + ", name=" + name + "]";
    }

}
