import { useNavigate } from "react-router-dom";

import { authService } from "../services/auth.service";

import { useAppDispatch } from "@/hooks/useAppDispatch";

import { loginSuccess } from "@/app/store/slices/authSlice";

import { tokenStorage } from "@/services/storage/tokenStorage";

import { toastService } from "@/shared/services/toast.service";

import type { LoginRequest } from "@/types/auth/auth.request";

export function useLogin() {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  async function login(request: LoginRequest) {
    try {
      const response =
        await authService.login(request);

      const data = response.data.data;

      tokenStorage.save(
        data.accessToken,
        data.refreshToken,
      );

      dispatch(
        loginSuccess({
          isAuthenticated: true,
          token: data.accessToken,
          refreshToken: data.refreshToken,
          user: data.user,
        }),
      );

      toastService.success(
        "Login Successful",
      );

      navigate("/dashboard");
    } catch {
      toastService.error(
        "Invalid Credentials",
      );
    }
  }

  return { login };
}