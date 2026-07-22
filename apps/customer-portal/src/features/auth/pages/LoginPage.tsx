import AuthLayout from "../components/AuthLayout";
import LoginForm from "../components/LoginForm";

export default function LoginPage() {
  return (
    <AuthLayout
      title="Welcome Back 👋"
      subtitle="Sign in to Apex Bank AI"
    >
      <LoginForm />
    </AuthLayout>
  );
}