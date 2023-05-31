package com.freecodingcamp.moviedb.controller;

import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecodingcamp.movie.api.MovieAPIs;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController implements MovieAPIs {

    @Autowired
    private MovieService movieService;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<MovieView>> getAllMovies(){
        return new ResponseEntity<List<MovieView>>(movieService.getAllMovies(), HttpStatus.OK);
    }

}
