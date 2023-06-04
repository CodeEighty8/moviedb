package com.freecodingcamp.moviedb.exceptions;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String errMsg){
        super(errMsg);
    }
}
