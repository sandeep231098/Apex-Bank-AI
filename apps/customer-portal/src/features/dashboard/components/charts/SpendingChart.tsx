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
  { day: "Mon", amount: 8000 },
  { day: "Tue", amount: 12000 },
  { day: "Wed", amount: 6000 },
  { day: "Thu", amount: 15000 },
  { day: "Fri", amount: 9000 },
  { day: "Sat", amount: 18000 },
  { day: "Sun", amount: 13000 },
];

export default function SpendingChart() {
  return (
    <ResponsiveContainer
      width="100%"
      height={320}
    >
      <AreaChart data={data}>
        <defs>
          <linearGradient
            id="colorSpend"
            x1="0"
            y1="0"
            x2="0"
            y2="1"
          >
            <stop
              offset="5%"
              stopColor="#3b82f6"
              stopOpacity={0.8}
            />
            <stop
              offset="95%"
              stopColor="#3b82f6"
              stopOpacity={0}
            />
          </linearGradient>
        </defs>

        <CartesianGrid strokeDasharray="3 3" />

        <XAxis dataKey="day" />

        <YAxis />

        <Tooltip />

        <Area
          type="monotone"
          dataKey="amount"
          stroke="#3b82f6"
          strokeWidth={3}
          fill="url(#colorSpend)"
        />
      </AreaChart>
    </ResponsiveContainer>
  );
}