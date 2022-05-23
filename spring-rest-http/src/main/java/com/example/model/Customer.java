package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:01 AM
**/
@Data
@NoArgsConstructor
public class Customer {
    private String id;
    private String telephone;
    private List<String> favorites;
    private Map<String,Boolean> communicationPreferences;

    public Customer(String id, String telephone, List<String> favorites, Map<String, Boolean> communicationPreferences) {
        this(telephone, favorites, communicationPreferences);
        this.id = id;
    }

    public Customer(String telephone, List<String> favorites, Map<String, Boolean> communicationPreferences) {
        this.telephone = telephone;
        this.favorites = favorites;
        this.communicationPreferences = communicationPreferences;
    }

    public static Customer fromCustomer(Customer customer) {
        return new Customer(customer.getId(), customer.getTelephone(), customer.getFavorites(), customer.getCommunicationPreferences());
    }
}
