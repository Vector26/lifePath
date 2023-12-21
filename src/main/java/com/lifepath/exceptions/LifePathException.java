package com.lifepath.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class LifePathException extends RuntimeException {

        @Getter
        private final HttpStatus responseHttpStatus;

        public LifePathException(final String message, final HttpStatus responseHttpStatus, final Throwable cause) {
            super(message, cause);
            this.responseHttpStatus = responseHttpStatus;
        }
}
