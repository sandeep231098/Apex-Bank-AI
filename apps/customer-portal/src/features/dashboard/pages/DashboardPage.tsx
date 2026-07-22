import Grid from "@mui/material/Grid";

import DashboardHeader from "../components/sections/DashboardHeader";
import HeroBalanceCard from "../components/hero/HeroBalanceCard";
import AnalyticsCard from "../components/AnalyticsCard";

import TransactionTable from "../components/tables/TransactionTable";
import BudgetProgress from "../components/widgets/BudgetProgress";

import CreditCardWidget from "../components/cards/CreditCardWidget";
import IncomeExpenseCard from "../components/cards/IncomeExpenseCard";
import ExchangeRates from "../components/widgets/ExchangeRates";
import QuickActions from "../components/widgets/QuickActions";

export default function DashboardPage() {
  return (
    <>
      <DashboardHeader />

      <HeroBalanceCard />

      <Grid
        container
        spacing={3}
        mt={3}
      >
        <Grid size={{ xs: 12 }}>
          <AnalyticsCard />
        </Grid>

        <Grid size={{ xs: 12, md: 7 }}>
          <TransactionTable />
        </Grid>

        <Grid size={{ xs: 12, md: 5 }}>
          <BudgetProgress />
        </Grid>
      </Grid>

      <Grid
        container
        spacing={3}
        mt={1}
      >
        <Grid size={{ xs: 12, md: 4 }}>
          <CreditCardWidget />
        </Grid>

        <Grid size={{ xs: 12, md: 4 }}>
          <IncomeExpenseCard />
        </Grid>

        <Grid size={{ xs: 12, md: 4 }}>
          <ExchangeRates />
        </Grid>
      </Grid>

      <Grid
        container
        spacing={3}
        mt={1}
      >
        <Grid size={{ xs: 12 }}>
          <QuickActions />
        </Grid>
      </Grid>
    </>
  );
}