package com.apexbank.auth.service.impl;

import com.apexbank.auth.dto.request.LoginRequest;
import com.apexbank.auth.dto.request.RegisterRequest;
import com.apexbank.auth.dto.response.LoginResponse;
import com.apexbank.auth.dto.response.UserResponse;
import com.apexbank.auth.entity.Role;
import com.apexbank.auth.entity.User;
import com.apexbank.auth.repository.UserRepository;
import com.apexbank.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);

        userRepository.save(user);

        return LoginResponse.builder()
                .accessToken("REGISTER_SUCCESS")
                .refreshToken("")
                .user(
                        UserResponse.builder()
                                .id(user.getId())
                                .firstName(user.getFirstName())
                                .lastName(user.getLastName())
                                .email(user.getEmail())
                                .role(user.getRole())
                                .build()
                )
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }
}