package com.example.validation.listValidation.controller;

import com.example.validation.listValidation.constraint.MaxSizeConstraint;
import com.example.validation.listValidation.model.Movie;
import com.example.validation.listValidation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 4/26/2022
    Time: 10:53 AM
**/
@Validated
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public void addAll(@RequestBody @NotEmpty(message = "Input movie list cannot be empty.") @MaxSizeConstraint List<@Valid Movie> movies) {
        movieService.addAll(movies);
    }
}
