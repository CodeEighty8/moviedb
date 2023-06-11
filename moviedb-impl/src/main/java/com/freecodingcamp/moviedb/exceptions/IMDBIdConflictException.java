package com.freecodingcamp.moviedb.exceptions;

public class IMDBIdConflictException extends RuntimeException{
    public IMDBIdConflictException(String errMsg){
        super(errMsg);
    }
}
