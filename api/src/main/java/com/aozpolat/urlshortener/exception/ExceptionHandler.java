package com.aozpolat.urlshortener.exception;

import com.aozpolat.urlshortener.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> shortenedUrlNotFoundExceptionHandler(ShortenedUrlNotFoundException shortenedUrlNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(shortenedUrlNotFoundException.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
