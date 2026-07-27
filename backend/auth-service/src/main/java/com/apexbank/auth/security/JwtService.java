package com.apexbank.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "ApexBankAISecretKey123456789012345678901234567890";

    private static final long EXPIRATION =
            1000 * 60 * 60 * 24;

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    public boolean isValid(String token, String username) {

        return extractUsername(token).equals(username)
                && !extractClaims(token).getExpiration().before(new Date());
    }

    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String generateRefreshToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7)
                ))
                .signWith(key)
                .compact();
    }
    public Date extractExpiration(String token) {

        return extractClaims(token).getExpiration();
    }
    public long getRemainingValidity(String token) {

        return extractExpiration(token).getTime()
                - System.currentTimeMillis();
    }
}