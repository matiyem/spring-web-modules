package com.example.service;

/*
    created by Atiye Mousavi
    Date: 5/19/2022
    Time: 3:55 PM
*/

import com.example.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("EmployeeListService")
public class EmployeeService {
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Manager"));
        employees.add(new Employee(2, "Java Developer"));
        return employees;
    }

    public void addEmployees(List<Employee> employees)
    {
        employees.forEach(e -> System.out.println("Adding new employee " + e));
    }
}
