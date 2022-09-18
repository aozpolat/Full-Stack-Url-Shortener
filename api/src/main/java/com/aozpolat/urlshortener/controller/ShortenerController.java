package com.aozpolat.urlshortener.controller;


import com.aozpolat.urlshortener.exception.ShortenedUrlNotFoundException;
import com.aozpolat.urlshortener.model.DeleteStatus;
import com.aozpolat.urlshortener.model.Request;
import com.aozpolat.urlshortener.model.Response;
import com.aozpolat.urlshortener.service.ShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class ShortenerController {
    private final ShortenerService shortenerService;

    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping()
    public ResponseEntity<Response> getUrl(@RequestBody Request url) {
        String shortenedUrl = shortenerService.createShortenedUrl(url.getUrl());
        String token = shortenerService.createToken(shortenedUrl);
        Response response = new Response("localhost:8080/v1/" + shortenedUrl, token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortenedUrl}")
    public void method(@PathVariable String shortenedUrl,  HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "http://" + shortenerService.transformShortenedUrltoOriginalUrl(shortenedUrl));
        httpServletResponse.setStatus(302);
    }


    @DeleteMapping("/{token}")
    public ResponseEntity deleteUrl(@PathVariable String token) {
        if(shortenerService.deleteUrl(token) == DeleteStatus.OK) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
