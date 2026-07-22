import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { Link } from "react-router-dom";

import {
  Alert,
  Box,
  Button,
  Checkbox,
  FormControlLabel,
  Stack,
  TextField,
} from "@mui/material";

import {
  loginSchema,
  type LoginFormData,
} from "../schemas/login.schema";

export default function LoginForm() {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm<LoginFormData>({
    resolver: zodResolver(loginSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });

  const onSubmit = async (data: LoginFormData) => {
    console.log(data);

    await new Promise((resolve) => setTimeout(resolve, 1000));

    alert("Login API will be connected in Spring Boot");
  };

  return (
    <Box
      component="form"
      onSubmit={handleSubmit(onSubmit)}
    >
      <Stack spacing={3}>
        <TextField
          label="Email"
          fullWidth
          {...register("email")}
          error={!!errors.email}
          helperText={errors.email?.message}
        />

        <TextField
          label="Password"
          type="password"
          fullWidth
          {...register("password")}
          error={!!errors.password}
          helperText={errors.password?.message}
        />

        <FormControlLabel
          control={<Checkbox />}
          label="Remember Me"
        />

        <Button
          type="submit"
          variant="contained"
          size="large"
          disabled={isSubmitting}
        >
          Sign In
        </Button>

        <Alert severity="info">
          Demo Credentials
          <br />
          admin@apexbank.ai
          <br />
          Password@123
        </Alert>

        <Button
          component={Link}
          to="/register"
          variant="text"
        >
          Don't have an account? Register
        </Button>
      </Stack>
    </Box>
  );
}