package com.freecodingcamp.moviedb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.freecodingcamp.movie.MovieAPIs;

@RestController
public class MovieController implements MovieAPIs {

    @Override
    public ResponseEntity<String > getAllMovies(){
        return new ResponseEntity<String>("All Movies", HttpStatus.OK);
    }

}
