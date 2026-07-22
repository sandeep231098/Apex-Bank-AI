import {
  Area,
  AreaChart,
  CartesianGrid,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

const data = [
  { month: "Jan", income: 65000, expense: 38000 },
  { month: "Feb", income: 72000, expense: 42000 },
  { month: "Mar", income: 69000, expense: 39000 },
  { month: "Apr", income: 81000, expense: 51000 },
  { month: "May", income: 84000, expense: 47000 },
  { month: "Jun", income: 91000, expense: 56000 },
];

export default function IncomeExpenseChart() {
  return (
    <ResponsiveContainer width="100%" height={350}>
      <AreaChart data={data}>
        <defs>
          <linearGradient id="income" x1="0" y1="0" x2="0" y2="1">
            <stop offset="5%" stopColor="#4F8CFF" stopOpacity={0.8} />
            <stop offset="95%" stopColor="#4F8CFF" stopOpacity={0} />
          </linearGradient>

          <linearGradient id="expense" x1="0" y1="0" x2="0" y2="1">
            <stop offset="5%" stopColor="#FF5C5C" stopOpacity={0.8} />
            <stop offset="95%" stopColor="#FF5C5C" stopOpacity={0} />
          </linearGradient>
        </defs>

        <CartesianGrid strokeDasharray="4 4" />

        <XAxis dataKey="month" />

        <YAxis />

        <Tooltip />

        <Area
          dataKey="income"
          stroke="#4F8CFF"
          fill="url(#income)"
        />

        <Area
          dataKey="expense"
          stroke="#FF5C5C"
          fill="url(#expense)"
        />
      </AreaChart>
    </ResponsiveContainer>
  );
}