package com.example.controller.controller;

import com.example.controller.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 1:35 PM
**/
@RestController
public class RestAnnotatedController {

    @GetMapping(value = "/annotated/student/{studentId}")
    public Student getData(@PathVariable Integer studentId){
        Student student=new Student();
        student.setName("Peter");
        student.setId(studentId);

        return student;
    }
}
