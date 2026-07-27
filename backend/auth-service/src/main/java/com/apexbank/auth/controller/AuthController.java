package com.apexbank.auth.controller;

import com.apexbank.auth.dto.request.*;
import com.apexbank.auth.dto.response.CurrentUserResponse;
import com.apexbank.auth.dto.response.LoginResponse;
import com.apexbank.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.apexbank.auth.dto.response.RefreshTokenResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(

            @RequestHeader("Authorization")
            String authorization,

            @RequestBody
            RefreshTokenRequest request) {

        String accessToken =
                authorization.substring(7);

        authService.logout(
                accessToken,
                request.getRefreshToken());
    }

    @GetMapping("/health")
    public String health() {
        return "Auth Service Running";
    }

    @GetMapping("/me")
    public CurrentUserResponse me() {

        return authService.getCurrentUser();
    }


    @PostMapping("/refresh")
    public RefreshTokenResponse refreshToken(
            @Valid @RequestBody RefreshTokenRequest request) {

        return authService.refreshToken(request);
    }
    @PostMapping("/forgot-password")
    @ResponseStatus(HttpStatus.OK)
    public void forgotPassword(
            @Valid @RequestBody ForgotPasswordRequest request) {

        authService.forgotPassword(request);
    }
    @PostMapping("/reset-password")
    @ResponseStatus(HttpStatus.OK)
    public void resetPassword(
            @Valid @RequestBody ResetPasswordRequest request) {

        authService.resetPassword(request);
    }
}