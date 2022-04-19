package com.example.spring.enums;

import com.example.boot.domain.Modes;
import org.springframework.web.bind.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 12:56 PM
**/
@RestController
@RequestMapping("/enums")
public class EnumController {

    @GetMapping("/mode2str")
    public String getStringToMode(@RequestParam("mode") Modes mode) {
        return "good";
    }

    @GetMapping("/findbymode/{mode}")
    public String findByEnum(@PathVariable Modes mode) {
        return "good";
    }

}
