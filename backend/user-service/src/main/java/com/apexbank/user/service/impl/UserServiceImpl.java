package com.apexbank.user.service.impl;

import com.apexbank.common.exception.BusinessException;
import com.apexbank.common.exception.ResourceNotFoundException;
import com.apexbank.user.dto.request.CreateUserRequest;
import com.apexbank.user.dto.response.UserResponse;
import com.apexbank.user.entity.User;
import com.apexbank.user.mapper.UserMapper;
import com.apexbank.user.repository.UserRepository;
import com.apexbank.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse create(CreateUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BusinessException("User already exists with email: " + request.getEmail());
        }

        User user = UserMapper.toEntity(request);

        User savedUser = repository.save(user);

        return UserMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse getById(UUID id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return UserMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}