package com.example.push.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.PushBuilder;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 12:36 PM
 **/
@Controller
public class PushController {
    // push builder برای توضیح است
    //فناوری فشار سرور می تواند زمان بارگذاری صفحات برنامه های ما را در بسیاری از سناریوها بهبود بخشد. با توجه به آنچه گفته شد، ما باید در نظر داشته باشیم که اگرچه تاخیر را کاهش می دهیم، می توانیم پهنای باند را افزایش دهیم - بسته به تعداد منابعی که در خدمت هستیم.

    @GetMapping("/demoWithPush")
    public String demoWithpsh(PushBuilder pushBuilder){
        if (null !=pushBuilder){
            pushBuilder.path("resources/logo.png");
        }
        return "demo";
    }
    @GetMapping(path = "/demoWithoutPush")
    public String demoWithoutPush(){
        return "demo";
    }

}
