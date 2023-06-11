package com.freecodingcamp.movie.api;

import com.freecodingcamp.movie.views.MovieView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping( value = "/api/v1/movie")
public interface MovieAPIs {
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<MovieView>> getAllMovies();

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable String id);

    @PostMapping
    public ResponseEntity<Object> addMovie(@RequestBody MovieView movieView);

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateMovie(@RequestBody MovieView movieView);
}
