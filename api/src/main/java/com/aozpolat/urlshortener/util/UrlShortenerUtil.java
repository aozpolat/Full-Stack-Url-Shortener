package com.aozpolat.urlshortener.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UrlShortenerUtil {
    Random r = new Random();
    public String generateToken() {
        String token = "";
        for(int i=0; i<10; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            token += c;
        }
        return token;
    }
}
