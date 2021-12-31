package com.example.controller;

import com.example.domain.Customer;
import com.example.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 10:58 AM
 **/
@Controller
public class CustomerController {

    @Autowired
    CustomerValidator validator;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("customerHome", "customer", new Customer());
    }
    @PostMapping("/addCustomer")
    public String submit(@Valid @ModelAttribute("customer")final Customer customer, final BindingResult result,final ModelMap model){
        validator.validate(customer,result);
        if (result.hasErrors()){
            return "customerHome";
        }
        model.addAttribute("customerId",customer.getCustomerId());
        model.addAttribute("customerName",customer.getCustomerName());
        model.addAttribute("customerContact",customer.getCustomerContact());
        model.addAttribute("customerEmail",customer.getCustomerEmail());
        return "customerView";

    }

}
