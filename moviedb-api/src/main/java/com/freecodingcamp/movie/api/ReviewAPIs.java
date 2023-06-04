package com.freecodingcamp.movie.api;

import com.freecodingcamp.movie.views.ReviewView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping( value = "/api/v1/reviews")
public interface ReviewAPIs {

    @PostMapping
    public ResponseEntity addReview(@RequestBody ReviewView reviewView);
}
