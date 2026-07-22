import { createSlice, type PayloadAction } from "@reduxjs/toolkit";

import type { UserResponse } from "@/types/auth/auth.response";

type AuthState = {
  isAuthenticated: boolean;
  token: string | null;
  refreshToken: string | null;
  user: UserResponse | null;
};

const initialState: AuthState = {
  isAuthenticated: false,
  token: null,
  refreshToken: null,
  user: null,
};

const authSlice = createSlice({
  name: "auth",

  initialState,

  reducers: {
    loginSuccess(
      state,
      action: PayloadAction<AuthState>,
    ) {
      state.isAuthenticated = true;
      state.token = action.payload.token;
      state.refreshToken =
        action.payload.refreshToken;
      state.user = action.payload.user;
    },

    updateUser(
      state,
      action: PayloadAction<UserResponse>,
    ) {
      state.user = action.payload;
    },

    logout(state) {
      state.isAuthenticated = false;
      state.token = null;
      state.refreshToken = null;
      state.user = null;
    },
  },
});

export const {
  loginSuccess,
  logout,
  updateUser,
} = authSlice.actions;

export default authSlice.reducer;