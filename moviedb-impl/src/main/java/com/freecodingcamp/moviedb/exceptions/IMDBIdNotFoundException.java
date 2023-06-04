package com.freecodingcamp.moviedb.exceptions;

public class IMDBIdNotFoundException extends Exception {
    public IMDBIdNotFoundException(String errMsg){
        super(errMsg);
    }
}
