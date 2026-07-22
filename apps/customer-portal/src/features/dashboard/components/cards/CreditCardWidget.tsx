import CreditCardRoundedIcon from "@mui/icons-material/CreditCardRounded";
import MoreHorizRoundedIcon from "@mui/icons-material/MoreHorizRounded";

import {
  Box,
  Card,
  CardContent,
  Chip,
  IconButton,
  Stack,
  Typography,
} from "@mui/material";

export default function CreditCardWidget() {
  return (
    <Card
      sx={{
        borderRadius: 5,
        height: "100%",
        background:
          "linear-gradient(135deg,#1d4ed8,#1e3a8a,#0f172a)",
        color: "#fff",
      }}
    >
      <CardContent>
        <Stack
          direction="row"
          justifyContent="space-between"
          alignItems="center"
        >
          <CreditCardRoundedIcon fontSize="large" />

          <IconButton sx={{ color: "#fff" }}>
            <MoreHorizRoundedIcon />
          </IconButton>
        </Stack>

        <Typography
          mt={4}
          variant="h5"
          fontWeight={700}
          letterSpacing={2}
        >
          •••• •••• •••• 4582
        </Typography>

        <Typography
          mt={3}
          color="grey.300"
        >
          Card Holder
        </Typography>

        <Typography fontWeight={700}>
          SANDEEP KUMAR
        </Typography>

        <Stack
          direction="row"
          justifyContent="space-between"
          mt={4}
        >
          <Box>
            <Typography
              variant="caption"
              color="grey.400"
            >
              VALID THRU
            </Typography>

            <Typography>08/30</Typography>
          </Box>

          <Chip
            label="VISA"
            color="primary"
          />
        </Stack>
      </CardContent>
    </Card>
  );
}