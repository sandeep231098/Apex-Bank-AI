package com.apexbank.beneficiary.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/beneficiaries")
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
                "service", "beneficiary-service",
                "status", "UP");
    }
}