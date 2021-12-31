package com.example.service;

import com.example.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 10:58 AM
 **/
@Service
public interface EmployeeService {

    List<Employee> getEmployeeList();
}
