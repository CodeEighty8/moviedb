package com.freecodingcamp.moviedb.helpers;

import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.exceptions.MovieDataIncompleteException;
import org.springframework.stereotype.Component;

@Component
public class MovieDataValidator {
    public void validate(MovieView movieView) throws MovieDataIncompleteException{
        if(movieView.getImdbId() == null || movieView.getImdbId().isBlank() || movieView.getGenres() == null || movieView.getGenres().isEmpty() || movieView.getTitle() == null || movieView.getTitle().isBlank()){
            throw new MovieDataIncompleteException("Missing IMDB ID or Title or Genres");
        }
    }
}
