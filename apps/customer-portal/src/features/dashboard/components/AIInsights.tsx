import Typography from "@mui/material/Typography";

import AppCard from "@/shared/components/ui/AppCard";

export default function AIInsights() {
  return (
    <AppCard>
      <Typography
        variant="h6"
        fontWeight={700}
      >
        🤖 AI Financial Insights
      </Typography>

      <Typography mt={2}>
        You spent 15% less than last week.
      </Typography>

      <Typography mt={1}>
        Your savings trend is improving.
      </Typography>

      <Typography mt={1}>
        Keep maintaining your current spending habits.
      </Typography>
    </AppCard>
  );
}