package com.example.spring.multiPartUpload;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 6:10 PM
 **/

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/employee")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/createEmployeeForm";
    }
    @RequestMapping(path = "/employee", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "employee/success";
    }
//    Another way of sending multipart data is to use @RequestParam.
    @RequestMapping(path = "/requestpart/employee",method = POST,consumes ={MediaType.MULTIPART_FORM_DATA_VALUE} )
    public ResponseEntity<Object> saveEmployee(@RequestPart Employee employee, @RequestPart MultipartFile document){
        employee.setDocument(document);
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(path = "/requestparam/employee",method = POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> saveEmployee(@RequestParam String name,@RequestPart MultipartFile document){
        Employee employee=new Employee(name,document);
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }



}
