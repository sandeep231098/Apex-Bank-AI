import AuthLayout from "../components/AuthLayout";
import RegisterForm from "../components/RegisterForm";

export default function RegisterPage() {
  return (
    <AuthLayout
      title="Create Account"
      subtitle="Open your Apex Bank AI account"
    >
      <RegisterForm />
    </AuthLayout>
  );
}