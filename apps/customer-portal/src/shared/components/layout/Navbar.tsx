import AppBar from "@mui/material/AppBar";
import Avatar from "@mui/material/Avatar";
import Badge from "@mui/material/Badge";
import Box from "@mui/material/Box";
import IconButton from "@mui/material/IconButton";
import InputBase from "@mui/material/InputBase";
import Toolbar from "@mui/material/Toolbar";

import NotificationsRoundedIcon from "@mui/icons-material/NotificationsRounded";
import SearchRoundedIcon from "@mui/icons-material/SearchRounded";

export default function Navbar() {
  return (
    <AppBar
      elevation={0}
      color="transparent"
      position="sticky"
    >
      <Toolbar>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            bgcolor: "background.paper",
            px: 2,
            py: 1,
            borderRadius: 3,
            width: 350,
          }}
        >
          <SearchRoundedIcon />

          <InputBase
            placeholder="Search..."
            sx={{ ml: 2 }}
          />
        </Box>

        <Box sx={{ flexGrow: 1 }} />

        <IconButton>
          <Badge badgeContent={4} color="error">
            <NotificationsRoundedIcon />
          </Badge>
        </IconButton>

        <Avatar sx={{ ml: 2 }}>
          D
        </Avatar>
      </Toolbar>
    </AppBar>
  );
}