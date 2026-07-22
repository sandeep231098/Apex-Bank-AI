import CreditCardRoundedIcon from "@mui/icons-material/CreditCardRounded";
import CurrencyExchangeRoundedIcon from "@mui/icons-material/CurrencyExchangeRounded";
import PaymentsRoundedIcon from "@mui/icons-material/PaymentsRounded";
import SavingsRoundedIcon from "@mui/icons-material/SavingsRounded";

import {
  Box,
  Button,
  Card,
  Chip,
  Stack,
  Typography,
} from "@mui/material";


export default function HeroBalanceCard() {
  return (
    <Card
      sx={{
        p: 4,
        borderRadius: 5,
        background:
          "linear-gradient(135deg,#1f4fff 0%,#111827 55%,#050816 100%)",
        position: "relative",
        overflow: "hidden",
        minHeight: 220,
      }}
    >
      <Chip
        label="Premium Banking"
        color="primary"
        sx={{
          mb: 3,
          fontWeight: 700,
        }}
      />

      <Typography color="grey.300">
        Available Balance
      </Typography>

      <Typography
  variant="h2"
  fontWeight={800}
  mt={1}
>
  ₹4,85,200
</Typography>

      <Typography
        color="grey.400"
        mt={1}
      >
        VISA PLATINUM •••• 4582
      </Typography>

      <Stack
        direction="row"
        spacing={2}
        mt={5}
        flexWrap="wrap"
      >
        <Button
          variant="contained"
          startIcon={<CurrencyExchangeRoundedIcon />}
        >
          Transfer
        </Button>

        <Button
          variant="outlined"
          startIcon={<PaymentsRoundedIcon />}
        >
          Pay Bills
        </Button>

        <Button
          variant="outlined"
          startIcon={<CreditCardRoundedIcon />}
        >
          Cards
        </Button>

        <Button
          variant="outlined"
          startIcon={<SavingsRoundedIcon />}
        >
          Invest
        </Button>
      </Stack>

      <Box
        sx={{
          position: "absolute",
          width: 350,
          height: 350,
          borderRadius: "50%",
          background: "rgba(255,255,255,.08)",
          right: -120,
          top: -120,
        }}
      />

      <Box
        sx={{
          position: "absolute",
          width: 200,
          height: 200,
          borderRadius: "50%",
          background: "rgba(255,255,255,.05)",
          right: 50,
          bottom: -100,
        }}
      />
    </Card>
  );
}