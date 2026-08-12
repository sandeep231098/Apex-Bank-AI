package com.apexbank.auth.service.impl;

import java.util.Map;

import com.apexbank.auth.client.dto.KeycloakTokenResponse;
import com.apexbank.auth.dto.request.*;
import com.apexbank.auth.dto.response.CurrentUserResponse;
import com.apexbank.auth.dto.response.LoginResponse;
import com.apexbank.auth.dto.response.RefreshTokenResponse;
import com.apexbank.auth.dto.response.UserResponse;
import com.apexbank.auth.entity.PasswordResetToken;
import com.apexbank.auth.entity.Role;
import com.apexbank.auth.entity.User;
import com.apexbank.auth.exception.ApiException;
import com.apexbank.auth.kafka.NotificationProducer;
import com.apexbank.auth.repository.PasswordResetTokenRepository;
import com.apexbank.auth.repository.UserRepository;
import com.apexbank.auth.service.AuthService;
import com.apexbank.auth.service.keycloak.KeycloakAuthService;
import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final NotificationProducer notificationProducer;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final KeycloakAuthService keycloakAuthService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public LoginResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ApiException("Email already exists");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);

        keycloakAuthService.register(request);

        userRepository.save(user);

        KeycloakTokenResponse token =
                keycloakAuthService.login(
                        request.getEmail(),
                        request.getPassword());

        return LoginResponse.builder()
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .user(buildUserResponse(user))
                .build();
    }
    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ApiException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new ApiException("Invalid email or password");
        }
        KeycloakTokenResponse token =
                keycloakAuthService.login(
                        request.getEmail(),
                        request.getPassword());

        return LoginResponse.builder()
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .user(buildUserResponse(user))
                .build();
    }
    @Override
    public CurrentUserResponse getCurrentUser() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ApiException("User not found"));

        return CurrentUserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    private UserResponse buildUserResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
    @Override
    public RefreshTokenResponse refreshToken(
            RefreshTokenRequest request) {

        KeycloakTokenResponse token =
                keycloakAuthService.refreshToken(
                        request.getRefreshToken());

        return RefreshTokenResponse.builder()
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .build();
    }
    @Override
    public void forgotPassword(ForgotPasswordRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ApiException("User not found"));

        PasswordResetToken token =
                PasswordResetToken.builder()
                        .token(UUID.randomUUID().toString())
                        .user(user)
                        .expiryDate(LocalDateTime.now().plusMinutes(30))
                        .used(false)
                        .build();

        passwordResetTokenRepository.save(token);


        NotificationEvent event =
                NotificationEvent.builder()

                        .eventId(UUID.randomUUID())

                        .notificationType(NotificationType.EMAIL)

                        .recipient(user.getEmail())

                        .subject("Reset Password")

                        .templateName("reset-password")

                        .variables(
                                Map.of(
                                        "firstName",
                                        user.getFirstName(),

                                        "resetLink",
                                        "http://localhost:5173/reset-password?token="
                                                + token.getToken()
                                )
                        )

                        .build();

        notificationProducer.publish(event);

        // TODO:
        // Publish Kafka Event
        // Notification Service will send email
    }
    @Override
    public boolean validateResetToken(String token) {

        PasswordResetToken passwordResetToken =
                passwordResetTokenRepository
                        .findByToken(token)
                        .orElseThrow(() ->
                                new ApiException("Invalid token"));

        return !passwordResetToken.isUsed()
                &&
                passwordResetToken
                        .getExpiryDate()
                        .isAfter(LocalDateTime.now());
    }
    @Override
    public void resetPassword(
            ResetPasswordRequest request) {

        PasswordResetToken token =
                passwordResetTokenRepository
                        .findByToken(request.getToken())
                        .orElseThrow(() ->
                                new ApiException("Invalid token"));

        if (token.isUsed()) {
            throw new ApiException("Token already used");
        }

        if (token.getExpiryDate()
                .isBefore(LocalDateTime.now())) {

            throw new ApiException("Token expired");
        }

        User user = token.getUser();

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        userRepository.save(user);

        token.setUsed(true);

        passwordResetTokenRepository.save(token);
    }
    @Override
    public void logout(
            String accessToken,
            String refreshTokenValue) {

        keycloakAuthService.logout(refreshTokenValue);



    }
}