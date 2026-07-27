package com.apexbank.auth.service;

import com.apexbank.auth.dto.request.*;
import com.apexbank.auth.dto.response.CurrentUserResponse;
import com.apexbank.auth.dto.response.LoginResponse;
import com.apexbank.auth.dto.response.RefreshTokenResponse;

public interface AuthService {

    LoginResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    CurrentUserResponse getCurrentUser();

    RefreshTokenResponse refreshToken(RefreshTokenRequest request);

    void logout(
            String accessToken,
            String refreshToken
    );
    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);

    boolean validateResetToken(String token);

}