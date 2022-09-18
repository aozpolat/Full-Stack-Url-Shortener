package com.aozpolat.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Response {
    private String shortenedUrl;
    private String token;
}
