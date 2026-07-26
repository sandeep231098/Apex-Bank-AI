package com.apexbank.user.controller;

import com.apexbank.common.response.ApiResponse;
import com.apexbank.user.dto.request.CreateUserRequest;
import com.apexbank.user.dto.response.UserResponse;
import com.apexbank.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ApiResponse<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User created successfully")
                .data(service.create(request))
                .timestamp(LocalDateTime.now().toString())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getById(@PathVariable UUID id) {

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User fetched successfully")
                .data(service.getById(id))
                .timestamp(LocalDateTime.now().toString())
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAll() {

        return ApiResponse.<List<UserResponse>>builder()
                .success(true)
                .message("Users fetched successfully")
                .data(service.getAll())
                .timestamp(LocalDateTime.now().toString())
                .build();
    }
}