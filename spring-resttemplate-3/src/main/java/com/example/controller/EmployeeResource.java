package com.example.controller;

/*
    created by Atiye Mousavi
    Date: 5/19/2022
    Time: 3:53 PM
*/

import com.example.dto.Employee;
import com.example.dto.EmployeeList;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<Employee> getEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v2")
    public EmployeeList getEmployeesUsingWrapperClass()
    {
        List<Employee> employees = employeeService.getAllEmployees();
        return new EmployeeList(employees);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public void addEmployees(@RequestBody List<Employee> employees)
    {
        employeeService.addEmployees(employees);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/v2")
    public void addEmployeesUsingWrapperClass(@RequestBody EmployeeList employeeWrapper)
    {
        employeeService.addEmployees(employeeWrapper.getEmployees());
    }
}
