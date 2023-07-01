package com.freecodingcamp.moviedb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.freecodingcamp.movie.api.MovieAPIs;
import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.exceptions.IMDBIdConflictException;
import com.freecodingcamp.moviedb.exceptions.IMDBIdNotFoundException;
import com.freecodingcamp.moviedb.exceptions.MovieDataIncompleteException;
import com.freecodingcamp.moviedb.exceptions.MovieNotFoundException;
import com.freecodingcamp.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController implements MovieAPIs {

    @Autowired
    private MovieService movieService;

    @Override
    public ResponseEntity<List<MovieView>> getAllMovies(){
        return new ResponseEntity<List<MovieView>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getMovieById(String id){
        try{
            MovieView movieView = movieService.getMovieById(id);
            return new ResponseEntity<Object>(movieView, HttpStatus.OK);
        }catch (MovieNotFoundException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return new ResponseEntity<>("Error getting movie for id : " + id, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Object> addMovie(MovieView movieView){
        try{
            return new ResponseEntity<>(
                    movieService.saveMovie(movieView),
                    HttpStatus.OK
            );
        } catch (MovieDataIncompleteException e){
            System.out.println(e);
            return new ResponseEntity<>("Missing IMDB ID or Title or Genres", HttpStatus.BAD_REQUEST);
        } catch (IMDBIdConflictException e){
            System.out.println(e);
            return new ResponseEntity<>("IMDB ID already present", HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return new ResponseEntity<>("Illegal argument", HttpStatus.BAD_REQUEST);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<Object> updateMovie(MovieView movieView){
        try {
            movieService.updateMovie(movieView);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IMDBIdNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IMDBIdConflictException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
