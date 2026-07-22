import {
  BrowserRouter,
  Navigate,
  Route,
  Routes,
} from "react-router-dom";

import DashboardPage from "@/features/dashboard/pages/DashboardPage";
import LoginPage from "@/features/auth/pages/LoginPage";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/login"
          element={<LoginPage />}
        />

        <Route
          path="/dashboard"
          element={<DashboardPage />}
        />

        <Route
          path="*"
          element={<Navigate to="/login" replace />}
        />
      </Routes>
    </BrowserRouter>
  );
}