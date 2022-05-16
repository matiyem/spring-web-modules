package com.example.resttemplate.web.service;

import com.example.resttemplate.web.dto.Person;
import org.springframework.stereotype.Component;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 3:13 PM
**/
@Component
public interface PersonService {
    public Person saveUpdatePerson(Person person);

    public Person findPersonById(Integer id);


}
