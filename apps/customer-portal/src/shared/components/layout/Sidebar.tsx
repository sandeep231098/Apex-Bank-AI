import Box from "@mui/material/Box";
import Divider from "@mui/material/Divider";
import List from "@mui/material/List";
import Typography from "@mui/material/Typography";

import { navigation } from "@/shared/constants/navigation";
import SidebarItem from "./SidebarItem";

export default function Sidebar() {
  return (
    <Box
      sx={{
        width: 280,
        minHeight: "100vh",
        bgcolor: "background.paper",
        borderRight: "1px solid rgba(255,255,255,.08)",
        p: 3,
      }}
    >
      <Typography
        variant="h4"
        color="primary.main"
        fontWeight={800}
      >
        Apex Bank AI
      </Typography>

      <Divider sx={{ my: 4 }} />

      <List>
        {navigation.map((item) => (
          <SidebarItem
            key={item.title}
            title={item.title}
            icon={item.icon}
          />
        ))}
      </List>
    </Box>
  );
}