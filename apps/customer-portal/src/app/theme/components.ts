import type { Components } from "@mui/material/styles";

export const components: Components = {
  MuiButton: {
    defaultProps: {
      disableElevation: true,
    },

    styleOverrides: {
      root: {
        borderRadius: 12,
        textTransform: "none",
        fontWeight: 600,
      },
    },
  },

  MuiCard: {
    styleOverrides: {
      root: {
        borderRadius: 18,
      },
    },
  },
};