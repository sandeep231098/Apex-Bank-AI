package com.apexbank.auth.client;

import com.apexbank.auth.client.dto.KeycloakTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class KeycloakClient {

    private final WebClient webClient;

    @Value("${keycloak.server-url}")
    private String serverUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public KeycloakTokenResponse login(
            String username,
            String password) {

        MultiValueMap<String, String> form =
                new LinkedMultiValueMap<>();

        form.add("grant_type", "password");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("username", username);
        form.add("password", password);

        return webClient
                .post()
                .uri(serverUrl +
                        "/realms/" +
                        realm +
                        "/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(form))
                .retrieve()
                .bodyToMono(KeycloakTokenResponse.class)
                .block();
    }

    public KeycloakTokenResponse refreshToken(
            String refreshToken) {

        MultiValueMap<String, String> form =
                new LinkedMultiValueMap<>();

        form.add("grant_type", "refresh_token");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("refresh_token", refreshToken);

        return webClient
                .post()
                .uri(serverUrl +
                        "/realms/" +
                        realm +
                        "/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(form))
                .retrieve()
                .bodyToMono(KeycloakTokenResponse.class)
                .block();
    }

    public void logout(String refreshToken) {

        MultiValueMap<String, String> form =
                new LinkedMultiValueMap<>();

        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("refresh_token", refreshToken);

        webClient
                .post()
                .uri(serverUrl +
                        "/realms/" +
                        realm +
                        "/protocol/openid-connect/logout")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(form))
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public String getAdminToken() {

        MultiValueMap<String, String> form =
                new LinkedMultiValueMap<>();

        form.add("grant_type", "client_credentials");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);

        KeycloakTokenResponse response =
                webClient
                        .post()
                        .uri(serverUrl +
                                "/realms/" +
                                realm +
                                "/protocol/openid-connect/token")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body(BodyInserters.fromFormData(form))
                        .retrieve()
                        .bodyToMono(KeycloakTokenResponse.class)
                        .block();

        return response.getAccessToken();
    }

    public void createUser(
            String adminToken,
            String json) {

        webClient
                .post()
                .uri(serverUrl +
                        "/admin/realms/" +
                        realm +
                        "/users")
                .header(HttpHeaders.AUTHORIZATION,
                        "Bearer " + adminToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

}