import api from "@/services/api/axios";

import type {
  ForgotPasswordRequest,
  LoginRequest,
  RegisterRequest,
  ResetPasswordRequest,
  VerifyOtpRequest,
} from "@/types/auth/auth.request";

import type {
  LoginResponse,
} from "@/types/auth/auth.response";

import type {
  ApiResponse,
} from "@/types/common/api.response";

export const authService = {
  login(request: LoginRequest) {
    return api.post<ApiResponse<LoginResponse>>(
      "/auth/login",
      request,
    );
  },

  register(request: RegisterRequest) {
    return api.post("/auth/register", request);
  },

  forgotPassword(request: ForgotPasswordRequest) {
    return api.post("/auth/forgot-password", request);
  },

  verifyOtp(request: VerifyOtpRequest) {
    return api.post("/auth/verify-otp", request);
  },

  resetPassword(request: ResetPasswordRequest) {
    return api.post("/auth/reset-password", request);
  },
};