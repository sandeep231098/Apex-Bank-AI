import { ENV } from "@/config/env";

export const tokenStorage = {
  save(token: string, refreshToken: string) {
    localStorage.setItem(
      ENV.TOKEN_KEY,
      token,
    );

    localStorage.setItem(
      ENV.REFRESH_TOKEN_KEY,
      refreshToken,
    );
  },

  getToken() {
    return localStorage.getItem(
      ENV.TOKEN_KEY,
    );
  },

  getRefreshToken() {
    return localStorage.getItem(
      ENV.REFRESH_TOKEN_KEY,
    );
  },

  clear() {
    localStorage.removeItem(
      ENV.TOKEN_KEY,
    );

    localStorage.removeItem(
      ENV.REFRESH_TOKEN_KEY,
    );
  },
};