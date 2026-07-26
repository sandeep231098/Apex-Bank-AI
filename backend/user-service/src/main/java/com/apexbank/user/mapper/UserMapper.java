package com.apexbank.user.mapper;

import com.apexbank.common.enums.KycStatus;
import com.apexbank.common.enums.UserStatus;
import com.apexbank.user.dto.request.CreateUserRequest;
import com.apexbank.user.dto.response.UserResponse;
import com.apexbank.user.entity.User;

import java.time.LocalDateTime;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(CreateUserRequest request) {

        return User.builder()
                .keycloakId(request.getKeycloakId())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .gender(request.getGender())
                .status(UserStatus.ACTIVE)
                .kycStatus(KycStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static UserResponse toResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .keycloakId(user.getKeycloakId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .gender(user.getGender())
                .status(user.getStatus())
                .kycStatus(user.getKycStatus())
                .build();
    }
}