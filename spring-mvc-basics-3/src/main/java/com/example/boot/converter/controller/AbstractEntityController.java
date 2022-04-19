package com.example.boot.converter.controller;

import com.example.boot.domain.Bar;
import com.example.boot.domain.Foo;
import com.example.boot.domain.Modes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:03 AM
**/
@RestController
@RequestMapping("/string-to-abstract")
public class AbstractEntityController {

    @GetMapping("/foo/{foo}")
    public ResponseEntity<Object> getStringToFoo(@PathVariable Foo foo) {
        return ResponseEntity.ok(foo);
    }

    @GetMapping("/bar/{bar}")
    public ResponseEntity<Object> getStringToBar(@PathVariable Bar bar) {
        return ResponseEntity.ok(bar);
    }
    @GetMapping
    public ResponseEntity<Object> getStringToMode(@RequestParam("mode")Modes mode){
        return ResponseEntity.ok(mode);
    }

}
