package com.freecodingcamp.moviedb.service;

import com.freecodingcamp.movie.views.ReviewView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.dao.MovieRepository;
import com.freecodingcamp.moviedb.dao.Review;
import com.freecodingcamp.moviedb.dao.ReviewRepository;
import com.freecodingcamp.moviedb.exceptions.IMDBIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.Optional;

@Component
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    private MongoTemplate mongoTemplate;

    public void addReview(ReviewView reviewView, String imdbId) throws IMDBIdNotFoundException, InvalidPropertiesFormatException{

        if(reviewView.getReview() == null || reviewView.getReview().isBlank()) {
            throw new InvalidPropertiesFormatException("Review value can't be empty or null");
        }

        Optional<Movie> movie = movieRepository.findByImdbId(imdbId).stream().findFirst();
        if (!movie.isPresent()) {
            throw new IMDBIdNotFoundException("Unknown IMDB ID: " + imdbId);
        }

        Movie saveMovie = movie.get();
        Review review = reviewRepository.insert(new Review(reviewView.getReview()));
        saveMovie.appendReviewIds(Collections.singletonList(review));
        movieRepository.save(saveMovie);
    }
}
