package com.avinash.urlshortener.controller;

import com.avinash.urlshortener.dto.*;
import com.avinash.urlshortener.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    // CREATE URL
    @PostMapping("/urls")
    public ApiResponse<UrlResponse> createShortUrl(@RequestBody UrlRequest request) {

        UrlResponse result = urlService.createShortUrl(request);

        return new ApiResponse<>(
                200,
                "Short URL created successfully",
                result
        );
    }

    // REDIRECT
    @GetMapping("/urls/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        UrlResponse response = urlService.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, response.getOriginalUrl())
                .build();
    }

    // ANALYTICS
    @GetMapping("/analytics/{shortCode}")
    public ApiResponse<AnalyticsResponse> getAnalytics(@PathVariable String shortCode) {

        AnalyticsResponse result = urlService.getAnalytics(shortCode);

        return new ApiResponse<>(
                200,
                "Analytics fetched successfully",
                result
        );
    }

    // UPDATE URL
    @PutMapping("/urls/{shortCode}")
    public ApiResponse<UrlResponse> updateUrl(@PathVariable String shortCode,
                                              @RequestBody UrlRequest request) {

        UrlResponse result = urlService.updateUrl(shortCode, request);

        return new ApiResponse<>(
                200,
                "URL updated successfully",
                result
        );
    }

    // DELETE URL
    @DeleteMapping("/urls/{shortCode}")
    public ApiResponse<String> deleteUrl(@PathVariable String shortCode) {

        urlService.deleteUrl(shortCode);

        return new ApiResponse<>(
                200,
                "URL deleted successfully",
                "Deleted"
        );
    }
}