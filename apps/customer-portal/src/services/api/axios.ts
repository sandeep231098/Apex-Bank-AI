import axios from "axios";

import { ENV } from "@/config/env";
import { tokenStorage } from "../storage/tokenStorage";

const api = axios.create({
  baseURL: ENV.API_BASE_URL,
  timeout: 10000,
});

api.interceptors.request.use((config) => {
  const token = tokenStorage.getToken();

  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }

  return config;
});

api.interceptors.response.use(
  (response) => response,

  (error) => {
    if (error.response?.status === 401) {
      tokenStorage.clear();

      window.location.href = "/login";
    }

    return Promise.reject(error);
  },
);

export default api;