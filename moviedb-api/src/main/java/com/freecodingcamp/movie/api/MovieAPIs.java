package com.freecodingcamp.movie.api;

import com.freecodingcamp.movie.views.MovieView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequestMapping( value = "/api/v1/movies")
public interface MovieAPIs {
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<MovieView>> getAllMovies();
}
