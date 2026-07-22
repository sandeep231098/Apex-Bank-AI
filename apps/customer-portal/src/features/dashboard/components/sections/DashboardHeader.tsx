import SearchRoundedIcon from "@mui/icons-material/SearchRounded";
import NotificationsRoundedIcon from "@mui/icons-material/NotificationsRounded";
import {
  Avatar,
  Badge,
  Box,
  IconButton,
  InputBase,
  Paper,
  Stack,
  Typography,
} from "@mui/material";

export default function DashboardHeader() {
  const hour = new Date().getHours();

  const greeting =
    hour < 12
      ? "Good Morning"
      : hour < 18
      ? "Good Afternoon"
      : "Good Evening";

  const today = new Date().toLocaleDateString("en-IN", {
    weekday: "long",
    day: "numeric",
    month: "long",
    year: "numeric",
  });

  return (
    <Stack
      direction="row"
      justifyContent="space-between"
      alignItems="center"
      mb={4}
      flexWrap="wrap"
      gap={3}
    >
      <Box>
        <Typography variant="h4" fontWeight={700}>
          {greeting}, Sandeep 👋
        </Typography>

        <Typography color="text.secondary">
          {today}
        </Typography>
      </Box>

      <Stack direction="row" spacing={2} alignItems="center">
        <Paper
          sx={{
            display: "flex",
            alignItems: "center",
            px: 2,
            py: 0.5,
            width: 280,
            borderRadius: 3,
          }}
        >
          <SearchRoundedIcon />

          <InputBase
            placeholder="Search..."
            sx={{ ml: 1, flex: 1 }}
          />
        </Paper>

        <IconButton>
          <Badge badgeContent={5} color="error">
            <NotificationsRoundedIcon />
          </Badge>
        </IconButton>

        <Avatar
          sx={{
            bgcolor: "primary.main",
            width: 42,
            height: 42,
            fontWeight: 700,
          }}
        >
          S
        </Avatar>
      </Stack>
    </Stack>
  );
}