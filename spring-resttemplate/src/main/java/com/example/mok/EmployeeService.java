package com.example.mok;

/*
    created by Atiye Mousavi
    Date: 5/3/2022
    Time: 1:42 PM
*/


import com.example.restTemplate.web.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EmployeeService {
    static final String EMP_URL_PREFIX = "http://localhost:8080/employee";
    static final String URL_SEP = "/";

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Employee getEmployee(String id){
        ResponseEntity<Employee> resp=restTemplate.getForEntity("http://localhost:8080/employee/"+id,
                Employee.class);
        return  resp.getStatusCode()== HttpStatus.OK ? resp.getBody() :null;
    }
}
