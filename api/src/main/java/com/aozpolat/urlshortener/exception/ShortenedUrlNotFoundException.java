package com.aozpolat.urlshortener.exception;

public class ShortenedUrlNotFoundException extends RuntimeException{

    public ShortenedUrlNotFoundException(String message) {
        super(message);
    }
}
