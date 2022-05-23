package com.example.service;

import com.example.model.Customer;

import java.util.Optional;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 11:08 AM
**/
public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> findCustomer(String id);

    void updateCustomer(Customer customer);
}
