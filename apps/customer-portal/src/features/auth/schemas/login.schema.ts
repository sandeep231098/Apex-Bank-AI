import { z } from "zod";

export const loginSchema = z.object({
  email: z
    .email("Invalid email")
    .min(1, "Email is required"),

  password: z
    .string()
    .min(8, "Minimum 8 characters"),
});

export type LoginFormData = z.infer<typeof loginSchema>;