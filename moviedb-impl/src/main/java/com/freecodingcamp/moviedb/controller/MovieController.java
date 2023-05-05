package com.freecodingcamp.moviedb.controller;

import org.springframework.web.bind.annotation.RestController;

import com.freecodingcamp.movie.MovieAPIs;

@RestController
public class MovieController implements MovieAPIs {

    @Override
    public String getAllMovies(){
        return "All Movies";
    }

}
