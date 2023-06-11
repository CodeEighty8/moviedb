package com.freecodingcamp.moviedb.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.dao.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieViewConverter {
    private ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public List<MovieView> convert(List<Movie> movies){
        List<MovieView> movieViews = new ArrayList<>();
        for(Movie movie: movies){
            movieViews.add(convert(movie));
        }
        return movieViews;
    }

    public MovieView convert(Movie movie){
        MovieView movieView = objectMapper.convertValue(movie, new TypeReference<MovieView>() {});
        List<String> reviews = new ArrayList<>();
        for(Review review: movie.getReviewIds()){
            reviews.add(review.getReview());
        }
        movieView.setReviews(reviews);
        return movieView;
    }

    public Movie convert(MovieView movieView){
        return objectMapper.convertValue(movieView, new TypeReference<Movie>() {});
    }
}
