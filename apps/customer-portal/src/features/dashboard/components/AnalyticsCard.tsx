import Grid from "@mui/material/Grid";

import SpendingChart from "./charts/SpendingChart";
import IncomeExpenseChart from "./charts/IncomeExpenseChart";

export default function AnalyticsCard() {
  return (
    <Grid container spacing={3}>
      <Grid size={{ xs: 12, lg: 8 }}>
        <SpendingChart />
      </Grid>

      <Grid size={{ xs: 12, lg: 4 }}>
        <IncomeExpenseChart />
      </Grid>
    </Grid>
  );
}