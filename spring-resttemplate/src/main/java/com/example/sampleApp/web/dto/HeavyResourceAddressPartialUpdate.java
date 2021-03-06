package com.example.sampleApp.web.dto;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 2:09 PM
*/


public class HeavyResourceAddressPartialUpdate {
    private Integer id;
    private String address;

    public HeavyResourceAddressPartialUpdate() {
    }

    public HeavyResourceAddressPartialUpdate(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
