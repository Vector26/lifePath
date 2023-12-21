package com.lifepath.configs;

import com.lifepath.dto.ExceptionResponseDTO;
import com.lifepath.exceptions.LifePathException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.nio.channels.ClosedChannelException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({LifePathException.class})
    public ResponseEntity<ExceptionResponseDTO> tartanExceptionHandler(final LifePathException ex) {
        log.error("Generic exception occurred {}", ex);
        ExceptionResponseDTO resp = new ExceptionResponseDTO(ex.getMessage());
        return new ResponseEntity<>(resp, ex.getResponseHttpStatus());
    }
}
