import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

import Logo from "@/shared/components/ui/Logo";

export default function App() {
  return (
    <Box
      display="flex"
      flexDirection="column"
      justifyContent="center"
      alignItems="center"
      minHeight="100vh"
      gap={2}
    >
      <Logo />

      <Typography variant="h5">
        Intelligent Banking. Simplified. Secured.
      </Typography>
    </Box>
  );
}