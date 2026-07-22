import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import Typography from "@mui/material/Typography";

import AppCard from "@/shared/components/ui/AppCard";

const transactions = [
  "Salary Credit",
  "Amazon Purchase",
  "Netflix Subscription",
  "Fuel Payment",
  "Electricity Bill",
];

export default function RecentTransactions() {
  return (
    <AppCard>
      <Typography
        variant="h6"
        mb={2}
        fontWeight={700}
      >
        Recent Transactions
      </Typography>

      <List>
        {transactions.map((item) => (
          <ListItem key={item}>
            {item}
          </ListItem>
        ))}
      </List>
    </AppCard>
  );
}