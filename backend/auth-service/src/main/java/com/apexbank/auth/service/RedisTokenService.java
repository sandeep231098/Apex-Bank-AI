package com.apexbank.auth.service;

public interface RedisTokenService {

    void blacklistToken(String token, long expirationMillis);

    boolean isBlacklisted(String token);

}