import type { ReactNode } from "react";

import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";

type Props = {
  children: ReactNode;
};

export default function AppCard({ children }: Props) {
  return (
    <Card
      elevation={0}
      sx={{
        backgroundColor: "background.paper",
        borderRadius: 4,
        border: "1px solid rgba(255,255,255,.08)",
        backdropFilter: "blur(20px)",
        transition: "all .25s ease",

        "&:hover": {
          transform: "translateY(-3px)",
          borderColor: "primary.main",
          boxShadow: "0 12px 32px rgba(59,130,246,.20)",
        },
      }}
    >
      <CardContent>{children}</CardContent>
    </Card>
  );
}