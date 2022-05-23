package com.example.requestMapping;

import com.example.web.dto.Bazz;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:06 AM
**/
@RestController
@RequestMapping("/bazz")
public class BazzNewMappingsExampleController {

    @GetMapping
    public ResponseEntity<?> getBazzs() throws JsonProcessingException {
        List<Bazz> data = Arrays.asList(
                new Bazz("1", "Bazz1"),
                new Bazz("2", "Bazz2"),
                new Bazz("3", "Bazz3"),
                new Bazz("4", "Bazz4"));
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBazz(@PathVariable String id){
        return new ResponseEntity<>(new Bazz(id, "Bazz"+id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> newBazz(@RequestParam("name") String name){
        return new ResponseEntity<>(new Bazz("5", name), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBazz(@PathVariable String id,
                                        @RequestParam("name") String name){
        return new ResponseEntity<>(new Bazz(id, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBazz(@PathVariable String id){
        return new ResponseEntity<>(new Bazz(id), HttpStatus.OK);
    }
}
