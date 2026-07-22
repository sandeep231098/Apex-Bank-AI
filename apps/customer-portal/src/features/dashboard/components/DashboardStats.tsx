import Grid from "@mui/material/Grid";

import StatCard from "@/shared/components/ui/StatCard";

import { dashboardData } from "../mock/dashboard.mock";

export default function DashboardStats() {
  return (
    <Grid container spacing={3}>
      <Grid size={{ xs: 12, md: 3 }}>
        <StatCard
          title="Available Balance"
          value={dashboardData.balance}
          change="+8.2%"
        />
      </Grid>

      <Grid size={{ xs: 12, md: 3 }}>
        <StatCard
          title="Monthly Income"
          value={dashboardData.income}
          change="+5.6%"
        />
      </Grid>

      <Grid size={{ xs: 12, md: 3 }}>
        <StatCard
          title="Monthly Expenses"
          value={dashboardData.expenses}
          change="-3.4%"
        />
      </Grid>

      <Grid size={{ xs: 12, md: 3 }}>
        <StatCard
          title="Savings"
          value={dashboardData.savings}
          change="+12.5%"
        />
      </Grid>
    </Grid>
  );
}