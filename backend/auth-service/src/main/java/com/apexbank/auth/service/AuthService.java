package com.apexbank.auth.service;

import com.apexbank.auth.dto.request.LoginRequest;
import com.apexbank.auth.dto.request.RegisterRequest;
import com.apexbank.auth.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}