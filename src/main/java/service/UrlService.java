package com.avinash.urlshortener.service;

import com.avinash.urlshortener.dto.AnalyticsResponse;
import com.avinash.urlshortener.dto.UrlRequest;
import com.avinash.urlshortener.dto.UrlResponse;
import com.avinash.urlshortener.entity.UrlEntity;
import com.avinash.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    // CREATE URL
    public UrlResponse createShortUrl(UrlRequest request) {

        UrlEntity entity = new UrlEntity();

        entity.setOriginalUrl(request.getUrl());
        entity.setShortCode(generateCode());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setClickCount(0);

        // CUSTOM EXPIRY
        Integer expiryDays = request.getExpiryDays();

        // Default expiry = 30 days
        if (expiryDays == null || expiryDays <= 0) {
            expiryDays = 30;
        }

        entity.setExpiryDate(LocalDateTime.now().plusDays(expiryDays));

        UrlEntity saved = repository.save(entity);

        return mapToResponse(saved);
    }

    // REDIRECT
    public UrlResponse getOriginalUrl(String shortCode) {

        UrlEntity entity = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        // Check if URL has expired
        if (entity.getExpiryDate() != null &&
                LocalDateTime.now().isAfter(entity.getExpiryDate())) {

            throw new RuntimeException("Short URL has expired");
        }

        entity.setClickCount(entity.getClickCount() + 1);
        entity.setLastAccessed(LocalDateTime.now());

        UrlEntity saved = repository.save(entity);

        return mapToResponse(saved);
    }

    // ANALYTICS
    public AnalyticsResponse getAnalytics(String shortCode) {

        UrlEntity entity = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        AnalyticsResponse response = new AnalyticsResponse();
        response.setClicks(entity.getClickCount());
        response.setCreatedAt(entity.getCreatedAt());
        response.setLastAccessed(entity.getLastAccessed());

        return response;
    }

    // UPDATE
    public UrlResponse updateUrl(String shortCode, UrlRequest request) {

        UrlEntity entity = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        entity.setOriginalUrl(request.getUrl());

        UrlEntity saved = repository.save(entity);

        return mapToResponse(saved);
    }

    // DELETE
    public void deleteUrl(String shortCode) {

        UrlEntity entity = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        repository.delete(entity);
    }

    // ENTITY -> DTO
    private UrlResponse mapToResponse(UrlEntity entity) {

        UrlResponse response = new UrlResponse();

        response.setId(entity.getId());
        response.setOriginalUrl(entity.getOriginalUrl());
        response.setShortCode(entity.getShortCode());
        response.setClickCount(entity.getClickCount());

        return response;
    }

    // SHORT CODE GENERATOR
    private String generateCode() {

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }

        return code.toString();
    }
}