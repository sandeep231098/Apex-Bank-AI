package com.apexbank.auth.service.impl;

import com.apexbank.auth.service.RedisTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisTokenServiceImpl
        implements RedisTokenService {

    private final StringRedisTemplate redisTemplate;

    @Override
    public void blacklistToken(
            String token,
            long expirationMillis) {

        redisTemplate.opsForValue()
                .set(
                        token,
                        "BLACKLISTED",
                        expirationMillis,
                        TimeUnit.MILLISECONDS
                );
    }

    @Override
    public boolean isBlacklisted(String token) {

        return Boolean.TRUE.equals(
                redisTemplate.hasKey(token)
        );
    }
}