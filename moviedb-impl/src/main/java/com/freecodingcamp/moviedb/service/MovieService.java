package com.freecodingcamp.moviedb.service;

import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.MovieRepository;
import com.freecodingcamp.moviedb.helpers.MovieViewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieViewConverter movieViewConverter;

    public List<MovieView> getAllMovies(){
        return movieViewConverter.convert(movieRepository.findAll());
    }
}
