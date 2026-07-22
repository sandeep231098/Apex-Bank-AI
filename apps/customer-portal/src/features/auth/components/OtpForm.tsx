import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import {
  Box,
  Button,
  Stack,
  TextField,
} from "@mui/material";

export default function OtpForm() {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data: any) => {
    console.log(data);
    alert("OTP Verified");
  };

  return (
    <Box component="form" onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        <TextField
          label="Enter OTP"
          fullWidth
          {...register("otp")}
        />

        <Button
          type="submit"
          variant="contained"
        >
          Verify OTP
        </Button>

        <Button
          component={Link}
          to="/login"
        >
          Cancel
        </Button>
      </Stack>
    </Box>
  );
}