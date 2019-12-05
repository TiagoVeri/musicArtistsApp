package com.music.exercise.service.exceptions;

//Error Treatment
public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //shows message error
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    //shows message error and error cause
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
