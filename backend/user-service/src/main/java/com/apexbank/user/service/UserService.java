package com.apexbank.user.service;

import com.apexbank.user.dto.request.CreateUserRequest;
import com.apexbank.user.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse create(CreateUserRequest request);

    UserResponse getById(UUID id);

    List<UserResponse> getAll();
}