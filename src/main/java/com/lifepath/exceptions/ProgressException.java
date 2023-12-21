package com.lifepath.exceptions;

import org.springframework.http.HttpStatus;

public class ProgressException extends LifePathException{
    public ProgressException(String message, Throwable cause) {
        super(message, HttpStatus.BAD_REQUEST, cause);
    }

    public ProgressException(String message) {
        this(message, null);
    }
}
