package com.example.boot.converter.controller;

import com.example.boot.domain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:09 AM
**/
@RestController
@RequestMapping("/string-to-employee")
public class StringToEmployeeConverterController {

    @GetMapping
    public ResponseEntity<Object> getStringToEmployee(@RequestParam("employee")Employee employee){
      return ResponseEntity.ok(employee);
    }
}
