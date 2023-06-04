package com.freecodingcamp.moviedb.controller;

import com.freecodingcamp.movie.views.MovieView;
import com.freecodingcamp.moviedb.dao.Movie;
import com.freecodingcamp.moviedb.dao.MovieRepository;
import com.freecodingcamp.moviedb.exceptions.MovieNotFoundException;
import com.freecodingcamp.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freecodingcamp.movie.api.MovieAPIs;

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

}
