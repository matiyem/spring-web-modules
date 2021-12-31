package com.example.controller;

import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 10:57 AM
 **/
@RestController()
@RequestMapping(value="/api")
public class RequestMethodController {

    @Autowired
    EmployeeService service;

    //اگر قسمت method را نگذاریم به این معنی است که تمام متد هارا ساپورت میکند
    @RequestMapping(value = "/employees", produces = "application/json", method={RequestMethod.GET,RequestMethod.POST})
    public List<Employee> findEmployees(){
        return service.getEmployeeList();
    }
}
