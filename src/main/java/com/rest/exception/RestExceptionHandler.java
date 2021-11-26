package com.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RestException.class})
    public ResponseEntity<Object> handlePagRestException(RestException ex, WebRequest request) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
