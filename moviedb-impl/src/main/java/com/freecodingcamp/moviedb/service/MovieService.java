package com.freecodingcamp.moviedb.service;

import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.dao.MovieRepository;
import com.freecodingcamp.moviedb.exceptions.MovieNotFoundException;
import com.freecodingcamp.moviedb.helpers.MovieViewConverter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieViewConverter movieViewConverter;

    public List<MovieView> getAllMovies(){
        return movieViewConverter.convert(movieRepository.findAll());
    }

    public MovieView getMovieById(String id) throws MovieNotFoundException, IllegalArgumentException {
        return movieViewConverter.convert(queryMovieById(id));
    }

    public Movie queryMovieById(String id) throws MovieNotFoundException, IllegalArgumentException{
        Optional<Movie> movie = movieRepository.findById( new ObjectId(id));
        if(movie.isPresent()){
            return movie.get();
        }
        throw new MovieNotFoundException("Movie not found for id: " + id);
    }

    public void saveMovie(Movie movie){
        try {
            movieRepository.save(movie);
        } catch (IllegalArgumentException e){
            System.out.println("Unable to save move. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
