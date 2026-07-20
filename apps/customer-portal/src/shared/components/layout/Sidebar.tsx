import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

export default function Sidebar() {
  return (
    <Box
      sx={{
        width: 260,
        minHeight: "100vh",
        bgcolor: "background.paper",
        borderRight: "1px solid rgba(255,255,255,.08)",
        p: 3,
      }}
    >
      <Typography variant="h5" color="primary.main" fontWeight={700}>
        Apex Bank AI
      </Typography>

      <Typography sx={{ mt: 5 }}>
        Dashboard
      </Typography>

      <Typography sx={{ mt: 2 }}>
        Accounts
      </Typography>

      <Typography sx={{ mt: 2 }}>
        Cards
      </Typography>

      <Typography sx={{ mt: 2 }}>
        Transfers
      </Typography>

      <Typography sx={{ mt: 2 }}>
        Loans
      </Typography>
    </Box>
  );
}