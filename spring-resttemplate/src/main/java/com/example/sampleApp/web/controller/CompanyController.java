package com.example.sampleApp.web.controller;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 2:14 PM
*/

import com.example.sampleApp.web.dto.Company;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @RequestMapping(value = "/companyRest", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getCompanyRest() {
        final Company company = new Company(1, "Xpto");
        return company;
    }
}
