package com.apexbank.account.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
                "service", "account-service",
                "status", "UP");
    }
}