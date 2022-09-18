package com.aozpolat.urlshortener.service;

import com.aozpolat.urlshortener.exception.ShortenedUrlNotFoundException;
import com.aozpolat.urlshortener.model.DeleteStatus;
import com.aozpolat.urlshortener.util.UrlShortenerUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class ShortenerService {
    public final UrlShortenerUtil urlShortenerUtil;
    private final HashMap<String, String> urlMap;
    private final HashMap<String, String> shortenedUrlMap;
    private final HashMap<String, String> tokenShortenedUrlMap;
    Random r = new Random();

    public ShortenerService(UrlShortenerUtil urlShortenerUtil) {
        this.urlShortenerUtil = urlShortenerUtil;
        this.urlMap = new HashMap<>();
        this.shortenedUrlMap = new HashMap<>();
        this.tokenShortenedUrlMap = new HashMap<>();
    }

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
        if(!shortenedUrlMap.containsKey(shortenedUrl)) throw new ShortenedUrlNotFoundException("The url that you are looking for is not available right now");
        return shortenedUrlMap.get(shortenedUrl);
    }

    public DeleteStatus deleteUrl(String token) {
        if(tokenShortenedUrlMap.containsKey(token)) {
            String shortenedUrl = tokenShortenedUrlMap.get(token);
            String url = shortenedUrlMap.get(shortenedUrl);
            shortenedUrlMap.remove(shortenedUrl);
            urlMap.remove(url);
            tokenShortenedUrlMap.remove(token);

            return DeleteStatus.OK;
        }
        return DeleteStatus.NOT_FOUND;
    }

    public String createToken(String shortenedUrl) {
        String token = urlShortenerUtil.generateToken();
        tokenShortenedUrlMap.put(token, shortenedUrl);
        return token;
    }
}
