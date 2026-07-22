import type { ReactNode } from "react";

import {
  Box,
  Container,
  Paper,
  Typography,
} from "@mui/material";

type Props = {
  title: string;
  subtitle: string;
  children: ReactNode;
};

export default function AuthLayout({
  title,
  subtitle,
  children,
}: Props) {
  return (
    <Box
      sx={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        background:
          "linear-gradient(135deg,#0f172a,#1e3a8a,#2563eb)",
      }}
    >
      <Container maxWidth="sm">
        <Paper
          elevation={10}
          sx={{
            p: 5,
            borderRadius: 5,
          }}
        >
          <Typography
            variant="h4"
            fontWeight={700}
          >
            {title}
          </Typography>

          <Typography
            color="text.secondary"
            mb={4}
          >
            {subtitle}
          </Typography>

          {children}
        </Paper>
      </Container>
    </Box>
  );
}