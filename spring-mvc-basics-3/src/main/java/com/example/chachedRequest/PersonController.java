package com.example.chachedRequest;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:49 AM
**/
@RestController
public class PersonController {

    @PostMapping(value = "/person")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void printPerson(@RequestBody Person person) {
        System.out.println("In Demo Controller. Person " + "is : " + person);
    }

    @GetMapping(value = "/person")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void getPerson() {
        System.out.println("In Demo Controller get method.");
    }
}
