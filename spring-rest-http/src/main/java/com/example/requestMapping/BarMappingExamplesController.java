package com.example.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:04 AM
**/
@Controller
@RequestMapping(value = "/ex")
public class BarMappingExamplesController {

    public BarMappingExamplesController() {
        super();
    }

    @RequestMapping(value = "/bars")
    @ResponseBody
    public String getBarBySimplePathWithRequestParam(@RequestParam("id") final long id) {
        return "Get a specific Bar with id=" + id;
    }
    @RequestMapping(value = "/bars", params = "id")
    @ResponseBody
    public String getBarBySimplePathWithExplicitRequestParam(@RequestParam("id") final long id) {
        return "Get a specific Bar with id=" + id;
    }
    @RequestMapping(value = "/bars", params = { "id", "second" })
    @ResponseBody
    public String getBarBySimplePathWithExplicitRequestParams(@RequestParam("id") final long id) {
        return "Get a specific Bar with id=" + id;
    }
    @RequestMapping(value = "/bars/{numericId:[\\d]+}")
    @ResponseBody
    public String getBarsBySimplePathWithPathVariable(@PathVariable final long numericId) {
        return "Get a specific Bar with id=" + numericId;
    }
}
