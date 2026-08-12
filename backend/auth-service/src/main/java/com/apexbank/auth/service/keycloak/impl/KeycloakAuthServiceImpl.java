package com.apexbank.auth.service.keycloak.impl;

import com.apexbank.auth.client.KeycloakClient;
import com.apexbank.auth.client.dto.KeycloakTokenResponse;
import com.apexbank.auth.dto.request.RegisterRequest;
import com.apexbank.auth.service.keycloak.KeycloakAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeycloakAuthServiceImpl implements KeycloakAuthService {

    private final KeycloakClient keycloakClient;

    @Override
    public KeycloakTokenResponse login(
            String username,
            String password) {

        return keycloakClient.login(
                username,
                password);
    }

    @Override
    public void register(RegisterRequest request) {

        String adminToken =
                keycloakClient.getAdminToken();

        String payload = """
                {
                  "enabled": true,
                  "username": "%s",
                  "email": "%s",
                  "firstName": "%s",
                  "lastName": "%s",
                  "emailVerified": true,
                  "credentials": [
                    {
                      "type": "password",
                      "value": "%s",
                      "temporary": false
                    }
                  ]
                }
                """.formatted(
                request.getEmail(),
                request.getEmail(),
                request.getFirstName(),
                request.getLastName(),
                request.getPassword()
        );

        keycloakClient.createUser(
                adminToken,
                payload);

    }

    @Override
    public void logout(
            String refreshToken) {

        keycloakClient.logout(refreshToken);

    }

    @Override
    public KeycloakTokenResponse refreshToken(
            String refreshToken) {

        return keycloakClient.refreshToken(
                refreshToken);

    }

}