package com.example.sampleApp.web.controller.mediaType;

import com.example.sampleApp.web.dto.BaeldungItem;
import com.example.sampleApp.web.dto.BaeldungItemV2;
import org.springframework.web.bind.annotation.*;

/*
    Create by Atiye Mousavi 
    Date: 5/16/2022
    Time: 10:05 AM
**/
@RestController
@RequestMapping(value = "/", produces = "application/vnd.baeldung.api.v1+json")
public class CustomMediaTypeController {

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.baeldung.api.v1+json")
    public @ResponseBody
    BaeldungItem getItem(@PathVariable("id") String id) {
        return new BaeldungItem("itemId1");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.baeldung.api.v2+json")
    public @ResponseBody BaeldungItemV2 getItemSecondAPIVersion(@PathVariable("id") String id) {
        return new BaeldungItemV2("itemName");
    }
}
