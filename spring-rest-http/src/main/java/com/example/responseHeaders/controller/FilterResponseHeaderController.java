package com.example.responseHeaders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:41 AM
**/
@RestController
@RequestMapping("/filter-response-header")
public class FilterResponseHeaderController {
    @GetMapping("/no-extra-header")
    public String FilterHeaderResponseWithNoExtraHeader() {
        return "Response body with Filter header and no extra header";
    }

    @GetMapping("/extra-header")
    public String FilterHeaderResponseWithExtraHeader(HttpServletResponse response) {
        response.addHeader("Baeldung-Example-Header", "Value-ExtraHeader");
        return "Response body with Filter header and one extra header";
    }
}
