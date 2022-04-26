package com.example.controller.controller;

import com.example.controller.student.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:40 PM
**/
@Controller
public class RestController {

    @GetMapping(value = "/student/{studentId}")
    public @ResponseBody
    Student getTestData(@PathVariable Integer studentId){
        Student student=new Student();
        student.setName("Peter");
        student.setId(studentId);

        return student;
    }
}
