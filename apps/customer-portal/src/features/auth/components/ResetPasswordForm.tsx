import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import {
  Box,
  Button,
  Stack,
  TextField,
} from "@mui/material";

export default function ResetPasswordForm() {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data: any) => {
    console.log(data);
    alert("Password Changed");
  };

  return (
    <Box component="form" onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        <TextField
          label="New Password"
          type="password"
          {...register("password")}
        />

        <TextField
          label="Confirm Password"
          type="password"
          {...register("confirmPassword")}
        />

        <Button
          type="submit"
          variant="contained"
          size="large"
        >
          Update Password
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