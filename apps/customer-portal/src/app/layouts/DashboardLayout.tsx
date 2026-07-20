import Box from "@mui/material/Box";
import { Outlet } from "react-router-dom";

import Navbar from "@/shared/components/layout/Navbar";
import Sidebar from "@/shared/components/layout/Sidebar";

export default function DashboardLayout() {
  return (
    <Box sx={{ display: "flex" }}>
      <Sidebar />

      <Box sx={{ flex: 1 }}>
        <Navbar />

        <Box sx={{ p: 3 }}>
          <Outlet />
        </Box>
      </Box>
    </Box>
  );
}