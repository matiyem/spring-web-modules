package com.example.resttemplate.web.controller;

import com.example.resttemplate.web.dto.Person;
import com.example.resttemplate.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 3:12 PM
**/
@RestController
public class PersonAPI {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String home(){
        return "Spring boot is working!";
    }
    @PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
    public Person createPerson(@RequestBody Person person) {
        return personService.saveUpdatePerson(person);
    }

    @PostMapping(value = "/updatePerson", consumes = "application/json", produces = "application/json")
    public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/findPerson/" + person.getId())
                .toUriString());
        return personService.saveUpdatePerson(person);
    }

}
