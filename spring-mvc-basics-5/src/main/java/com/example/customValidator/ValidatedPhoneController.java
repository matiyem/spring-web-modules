package com.example.customValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/*
    Create by Atiye Mousavi 
    Date: 5/1/2022
    Time: 10:04 AM
**/
@Controller
public class ValidatedPhoneController {

    @GetMapping("/validatePhone")
    public String loadFormPage(Model m){
        m.addAttribute("validatedPhone",new ValidatedPhone());
        return "phoneHome";
    }
    @PostMapping("/addValidatePhone")
    public String submitForm(@Valid ValidatedPhone validatedPhone, BindingResult result,Model m){
        if (result.hasErrors()){
            return "phoneHome";
        }
        m.addAttribute("message", "Successfully saved phone: " + validatedPhone.toString());
        return "phoneHome";
    }
}
