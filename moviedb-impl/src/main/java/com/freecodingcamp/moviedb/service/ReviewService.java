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
import java.util.Optional;

@Component
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    MovieRepository movieRepository;

    private MongoTemplate mongoTemplate;

    public void addReview(ReviewView reviewView, String imdbId) throws IMDBIdNotFoundException{

        Optional<Movie> movie = movieRepository.findByImdbId(imdbId).stream().findFirst();
        if(movie.isPresent()){
            Movie saveMovie = movie.get();

            Review review = reviewRepository.insert(new Review(reviewView.getReviewBody()));
            saveMovie.setReviewIDs(Collections.singletonList(review));
            movieRepository.save(saveMovie);
        } else {
            throw new IMDBIdNotFoundException("Unknown IMDB ID: " + imdbId);
        }
    }

}
