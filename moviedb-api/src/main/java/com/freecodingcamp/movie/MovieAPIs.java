package com.freecodingcamp.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping( value = "/api/v1/movies")
public interface MovieAPIs {
    
    @GetMapping(value = "/all")
    public ResponseEntity<String> getAllMovies();
}
