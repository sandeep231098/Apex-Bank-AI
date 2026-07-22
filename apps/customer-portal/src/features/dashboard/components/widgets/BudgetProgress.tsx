import {
  Card,
  CardContent,
  LinearProgress,
  Stack,
  Typography,
} from "@mui/material";

export default function BudgetProgress() {
  return (
    <Card
      sx={{
        borderRadius: 5,
        height: 430,
      }}
    >
      <CardContent>
        <Typography
          variant="h6"
          fontWeight={700}
          mb={4}
        >
          Budget Progress
        </Typography>

        <Stack spacing={4}>
          <div>
            <Typography mb={1}>Food</Typography>

            <LinearProgress
              variant="determinate"
              value={70}
            />

            <Typography
              mt={1}
              variant="body2"
            >
              ₹14,000 / ₹20,000
            </Typography>
          </div>

          <div>
            <Typography mb={1}>Travel</Typography>

            <LinearProgress
              variant="determinate"
              value={45}
              color="success"
            />

            <Typography
              mt={1}
              variant="body2"
            >
              ₹9,000 / ₹20,000
            </Typography>
          </div>

          <div>
            <Typography mb={1}>Shopping</Typography>

            <LinearProgress
              variant="determinate"
              value={82}
              color="warning"
            />

            <Typography
              mt={1}
              variant="body2"
            >
              ₹16,400 / ₹20,000
            </Typography>
          </div>
        </Stack>
      </CardContent>
    </Card>
  );
}