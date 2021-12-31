package com.example.spring.multiPartUpload;

import org.springframework.stereotype.Repository;

/**
 * Create by Atiye Mousavi
 * Date: 12/11/2021
 * Time: 3:03 PM
 **/
@Repository
public interface EmployeeRepository {
    void saveEmployee(Employee employee);
}
