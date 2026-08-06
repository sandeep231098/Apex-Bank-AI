package com.apexbank.user.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
                "service", "user-service",
                "status", "UP");
    }
}