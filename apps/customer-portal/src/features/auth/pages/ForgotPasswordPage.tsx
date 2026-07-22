import AuthLayout from "../components/AuthLayout";
import ForgotPasswordForm from "../components/ForgotPasswordForm";

export default function ForgotPasswordPage() {
  return (
    <AuthLayout
      title="Forgot Password"
      subtitle="Recover your account"
    >
      <ForgotPasswordForm />
    </AuthLayout>
  );
}