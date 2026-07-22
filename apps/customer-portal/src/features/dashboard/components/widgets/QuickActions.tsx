import AccountBalanceRoundedIcon from "@mui/icons-material/AccountBalanceRounded";
import CreditCardRoundedIcon from "@mui/icons-material/CreditCardRounded";
import CurrencyExchangeRoundedIcon from "@mui/icons-material/CurrencyExchangeRounded";
import PaymentsRoundedIcon from "@mui/icons-material/PaymentsRounded";

import {
  Button,
  Card,
  CardContent,
  Grid,
  Typography,
} from "@mui/material";

export default function QuickActions() {
  return (
    <Card
      sx={{
        borderRadius: 5,
      }}
    >
      <CardContent>
        <Typography
          variant="h6"
          fontWeight={700}
          mb={3}
        >
          Quick Actions
        </Typography>

        <Grid container spacing={2}>
          <Grid size={{ xs: 12, md: 3 }}>
            <Button
              fullWidth
              variant="contained"
              startIcon={<CurrencyExchangeRoundedIcon />}
            >
              Transfer
            </Button>
          </Grid>

          <Grid size={{ xs: 12, md: 3 }}>
            <Button
              fullWidth
              variant="outlined"
              startIcon={<PaymentsRoundedIcon />}
            >
              Pay Bills
            </Button>
          </Grid>

          <Grid size={{ xs: 12, md: 3 }}>
            <Button
              fullWidth
              variant="outlined"
              startIcon={<CreditCardRoundedIcon />}
            >
              Cards
            </Button>
          </Grid>

          <Grid size={{ xs: 12, md: 3 }}>
            <Button
              fullWidth
              variant="outlined"
              startIcon={<AccountBalanceRoundedIcon />}
            >
              Loan
            </Button>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
}