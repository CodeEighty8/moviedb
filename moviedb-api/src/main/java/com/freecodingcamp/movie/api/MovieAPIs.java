package com.freecodingcamp.movie.api;

import com.freecodingcamp.movie.views.MovieView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping( value = "/api/v1/movies")
public interface MovieAPIs {
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<MovieView>> getAllMovies();

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable String id);
}
