package com.freecodingcamp.movie.api;

import com.freecodingcamp.movie.views.ReviewView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping( value = "/api/v1/reviews")
public interface ReviewAPIs {

    @PutMapping("/imdbId/{imdbId}")
    public ResponseEntity addReview(@RequestBody ReviewView reviewView, @PathVariable String imdbId);
}