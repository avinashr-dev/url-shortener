package com.avinash.urlshortener.dto;

public class UrlRequest {

    private String url;
    private Integer expiryDays;

    public UrlRequest() {
    }

    public UrlRequest(String url, Integer expiryDays) {
        this.url = url;
        this.expiryDays = expiryDays;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(Integer expiryDays) {
        this.expiryDays = expiryDays;
    }
}