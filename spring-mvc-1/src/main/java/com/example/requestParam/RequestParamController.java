package com.example.requestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 12:40 PM
 **/
@Controller
public class RequestParamController {

    @GetMapping("/api/foos")
    public String getFoos(@RequestParam String id){
        return "ID: " + id;
    }
    @PostMapping("/api/foos")
    public String addFoo(@RequestParam(name = "id") String fooId,@RequestParam String name){
        return "ID: " + fooId;
    }
    @GetMapping("/api/foos2")
    public String getFoo2(@RequestParam(required = true)String id){
        return "ID: " + id;
    }
    @GetMapping("/api/foosOptional")
    public String getFoosOptional(@RequestParam Optional<String> id){
        return "ID: " + id.orElseGet(()-> "not provided");
    }
    @GetMapping("/api/foos3")
    public String getFoos3(@RequestParam(defaultValue = "test")String id){
        return "ID: " + id;
    }
    @PostMapping("/api/foos1")
    public String updateFoos(@RequestParam Map<String,String> allParams){
        return "Parameters are " + allParams.entrySet();
    }
    @GetMapping("/api/foos4")
    public String getFoos4(@RequestParam List<String> id){
        return "IDs are " + id;
    }
    @GetMapping("/foos/{id}")
    public String getFooById(@PathVariable String id){
        return "ID: " + id;
    }
    @GetMapping("/foos")
    public String getFooByIdUsingQueryParam(@RequestParam String id){
        return "ID: " + id;
    }
    @GetMapping({"/myfoos/optional" , "/myfoos/optional/{id}"})
    public String getFooByOptionalId(@PathVariable(required = true)String id){
        return "ID: "+id;
    }
    @GetMapping("/myfoos/optionalParam")
    public String getFooByOptionalIdUsingQueryParam(@RequestParam(required = true)String id){
        return "ID: " + id;
    }


}
