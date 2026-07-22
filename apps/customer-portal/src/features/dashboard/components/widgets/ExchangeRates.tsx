import {
  Card,
  CardContent,
  Divider,
  Stack,
  Typography,
} from "@mui/material";

const rates = [
  {
    currency: "USD",
    value: "₹87.15",
  },
  {
    currency: "EUR",
    value: "₹101.22",
  },
  {
    currency: "GBP",
    value: "₹116.40",
  },
  {
    currency: "AED",
    value: "₹23.73",
  },
];

export default function ExchangeRates() {
  return (
    <Card
      sx={{
        borderRadius: 5,
        height: "100%",
      }}
    >
      <CardContent>
        <Typography
          variant="h6"
          fontWeight={700}
          mb={3}
        >
          Exchange Rates
        </Typography>

        <Stack spacing={2}>
          {rates.map((rate) => (
            <div key={rate.currency}>
              <Stack
                direction="row"
                justifyContent="space-between"
              >
                <Typography>
                  {rate.currency}
                </Typography>

                <Typography fontWeight={700}>
                  {rate.value}
                </Typography>
              </Stack>

              <Divider sx={{ mt: 2 }} />
            </div>
          ))}
        </Stack>
      </CardContent>
    </Card>
  );
}