package com.avinash.urlshortener.dto;

public class UrlRequest {

    private String url;

    // NEW FIELD
    private Integer expiryDays;

    // Getter and Setter for url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getter and Setter for expiryDays
    public Integer getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(Integer expiryDays) {
        this.expiryDays = expiryDays;
    }
}