import TrendingUpRoundedIcon from "@mui/icons-material/TrendingUpRounded";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

import AppCard from "./AppCard";

type Props = {
  title: string;
  value: string;
  change: string;
};

export default function StatCard({
  title,
  value,
  change,
}: Props) {
  return (
    <AppCard>
      <Typography
        color="text.secondary"
        variant="body2"
      >
        {title}
      </Typography>

      <Typography
        variant="h4"
        mt={2}
        fontWeight={700}
      >
        {value}
      </Typography>

      <Box
        mt={2}
        display="flex"
        alignItems="center"
        gap={1}
      >
        <TrendingUpRoundedIcon
          color="success"
          fontSize="small"
        />

        <Typography
          color="success.main"
          fontWeight={600}
        >
          {change}
        </Typography>
      </Box>
    </AppCard>
  );
}