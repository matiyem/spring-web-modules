package com.example.dto;

/*
    created by Atiye Mousavi
    Date: 5/19/2022
    Time: 3:52 PM
*/


import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    public List<Employee> employees;

    public EmployeeList()
    {
        employees = new ArrayList<>();
    }

    public EmployeeList(List<Employee> employees)
    {
        this.employees = employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }
}
