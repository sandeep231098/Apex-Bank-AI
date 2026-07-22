import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

import {
  Alert,
  Box,
  Button,
  Stack,
  TextField,
} from "@mui/material";

import {
  registerSchema,
  type RegisterFormData,
} from "../schemas/register.schema";

export default function RegisterForm() {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<RegisterFormData>({
    resolver: zodResolver(registerSchema),
  });

  const onSubmit = async (data: RegisterFormData) => {
    console.log(data);

    await new Promise((resolve) => setTimeout(resolve, 1000));

    alert("Registration API will be connected in Spring Boot");
  };

  return (
    <Box
      component="form"
      onSubmit={handleSubmit(onSubmit)}
    >
      <Stack spacing={3}>
        <TextField
          label="First Name"
          {...register("firstName")}
          error={!!errors.firstName}
          helperText={errors.firstName?.message}
        />

        <TextField
          label="Last Name"
          {...register("lastName")}
          error={!!errors.lastName}
          helperText={errors.lastName?.message}
        />

        <TextField
          label="Email"
          {...register("email")}
          error={!!errors.email}
          helperText={errors.email?.message}
        />

        <TextField
          label="Password"
          type="password"
          {...register("password")}
          error={!!errors.password}
          helperText={errors.password?.message}
        />

        <TextField
          label="Confirm Password"
          type="password"
          {...register("confirmPassword")}
          error={!!errors.confirmPassword}
          helperText={errors.confirmPassword?.message}
        />

        <Button
          variant="contained"
          size="large"
          type="submit"
          disabled={isSubmitting}
        >
          Create Account
        </Button>

        <Alert severity="info">
          Password must contain at least 8 characters.
        </Alert>
      </Stack>
    </Box>
  );
}