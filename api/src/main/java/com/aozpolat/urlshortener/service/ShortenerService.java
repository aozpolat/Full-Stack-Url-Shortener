package com.aozpolat.urlshortener.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class ShortenerService {
    HashMap<String, String> urlMap = new HashMap<>();
    HashMap<String, String> shortenedUrlMap = new HashMap<>();

    HashMap<String, String> tokenShortenedUrlMap = new HashMap<>();
    Random r = new Random();

    public String createShortenedUrl(String url) {
        String shortenedUrl = "";
        if (!urlMap.containsKey(url)) {
            while (true) {
                shortenedUrl = "";
                for (int i = 0; i < 7; i++) {
                    char c = (char) (r.nextInt(26) + 'a');
                    shortenedUrl += c;
                }

                if (!shortenedUrlMap.containsKey(shortenedUrl)) {
                    urlMap.put(url, shortenedUrl);
                    shortenedUrlMap.put(shortenedUrl, url);
                    break;
                }
            }

            return shortenedUrl;
        }

       return urlMap.get(url);
    }

    public String transformShortenedUrltoOriginalUrl(String shortenedUrl) {
        return shortenedUrlMap.get(shortenedUrl);
    }

    public String createToken(String shortenedUrl) {
        String token = "";
        for(int i=0; i<10; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            token += c;
        }
        tokenShortenedUrlMap.put(token, shortenedUrl);

        return token;
    }

}
