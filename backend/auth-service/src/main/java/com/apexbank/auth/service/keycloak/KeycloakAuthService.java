package com.apexbank.auth.service.keycloak;

import com.apexbank.auth.client.dto.KeycloakTokenResponse;
import com.apexbank.auth.dto.request.RegisterRequest;

public interface KeycloakAuthService {

    KeycloakTokenResponse login(
            String username,
            String password
    );

    void register(
            RegisterRequest request
    );

    void logout(
            String refreshToken
    );

    KeycloakTokenResponse refreshToken(
            String refreshToken
    );
}