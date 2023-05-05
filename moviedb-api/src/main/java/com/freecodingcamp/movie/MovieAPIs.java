package com.freecodingcamp.movie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/api/v1/movies")
public interface MovieAPIs {
    
    @GetMapping("/all")
    public String getAllMovies();
}
