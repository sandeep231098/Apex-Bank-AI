package com.apexbank.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @GetMapping("/public/health")
    public String health() {
        return "Application Running";
    }

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }

}