package com.example.resttemplate.web.service;

import com.example.resttemplate.web.dto.Person;

/*
    Create by Atiye Mousavi 
    Date: 5/16/2022
    Time: 9:48 AM
**/
public class PersonServiceImpl implements PersonService{
    @Override
    public Person saveUpdatePerson(Person person) {
        return person;
    }

    @Override
    public Person findPersonById(Integer id) {
        return new Person(id,"John");
    }
}
