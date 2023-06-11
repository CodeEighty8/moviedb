package com.freecodingcamp.moviedb.exceptions;

public class MovieDataIncompleteException extends RuntimeException{
    public MovieDataIncompleteException(String errMsg){
        super(errMsg);
    }
}
