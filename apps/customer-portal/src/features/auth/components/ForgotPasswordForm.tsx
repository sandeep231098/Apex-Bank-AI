import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import {
  Box,
  Button,
  Stack,
  TextField,
} from "@mui/material";

export default function ForgotPasswordForm() {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data: any) => {
    console.log(data);
    alert("OTP will be sent from Spring Boot.");
  };

  return (
    <Box component="form" onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        <TextField
          label="Email Address"
          fullWidth
          {...register("email")}
        />

        <Button
          type="submit"
          variant="contained"
          size="large"
        >
          Send OTP
        </Button>

        <Button
          component={Link}
          to="/login"
        >
          Back to Login
        </Button>
      </Stack>
    </Box>
  );
}