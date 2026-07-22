import { z } from "zod";

export const registerSchema = z
  .object({
    firstName: z.string().min(2),

    lastName: z.string().min(2),

    email: z.email(),

    password: z.string().min(8),

    confirmPassword: z.string().min(8),
  })
  .refine((data) => data.password === data.confirmPassword, {
    message: "Passwords do not match",
    path: ["confirmPassword"],
  });

export type RegisterFormData = z.infer<typeof registerSchema>;