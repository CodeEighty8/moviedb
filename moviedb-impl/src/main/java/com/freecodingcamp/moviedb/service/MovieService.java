package com.freecodingcamp.moviedb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.dao.MovieRepository;
import com.freecodingcamp.moviedb.exceptions.IMDBIdConflictException;
import com.freecodingcamp.moviedb.exceptions.IMDBIdNotFoundException;
import com.freecodingcamp.moviedb.exceptions.MovieDataIncompleteException;
import com.freecodingcamp.moviedb.exceptions.MovieNotFoundException;
import com.freecodingcamp.moviedb.helpers.MovieDataValidator;
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

    @Autowired
    private MovieDataValidator movieDataValidator;

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

    public String saveMovie(MovieView movieView)
            throws MovieDataIncompleteException, IMDBIdConflictException, IllegalArgumentException, JsonProcessingException {
        movieDataValidator.validate(movieView);

        List<Movie> movies = movieRepository.findByImdbId(movieView.getImdbId());
        if(!movies.isEmpty()) {
            throw new IMDBIdConflictException("IMDB ID already present " + movieView.getImdbId());
        }

        Movie movie = movieViewConverter.convert(movieView);
        return movieRepository.save(movie).getImdbId();
    }

    public void updateMovie(MovieView movieView) throws IMDBIdNotFoundException, IMDBIdConflictException, IllegalArgumentException {
        movieDataValidator.validate(movieView);

        List<Movie> movies = movieRepository.findByImdbId(movieView.getImdbId());
        if(movies.isEmpty()){
            throw new IMDBIdNotFoundException("No movie found for IMDB ID " + movieView.getImdbId());
        }

        if(movies.size() > 1){
            throw  new IMDBIdConflictException("More than one movie found for IMDB ID " + movieView.getImdbId());
        }

        Movie movie = movies.get(0);

        movie.setReleaseDate(movieView.getReleaseDate());
        movie.setTrailerLink(movieView.getTrailerLink());
        movie.setGenres(movieView.getGenres());
        movie.setPoster(movieView.getPoster());
        movie.setBackdrops(movieView.getBackdrops());

        movieRepository.save(movie);
    }
}
