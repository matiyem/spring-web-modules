package com.example.controller;

import com.example.domain.Employee;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 12:12 PM
 **/
@Controller
public class EmployeeController {

    Map<Long, Employee> employeeMap = new HashedMap();

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeHome", "employee", new Employee());
    }
    @RequestMapping(value = "/employee/{Id}",produces = {"application/json","application/xml"},method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable final long id){
        return employeeMap.get(id);
    }
    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee") final Employee employee, final BindingResult result,final ModelMap model){
        if (result.hasErrors()){
            return "error";
        }
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        model.addAttribute("id",employee.getId());
        employeeMap.put(employee.getId(),employee);
        return "employeeView";
    }

}
