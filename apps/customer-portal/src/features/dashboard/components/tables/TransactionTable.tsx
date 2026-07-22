import {
  Card,
  CardContent,
  Chip,
  Stack,
  Typography,
} from "@mui/material";

import { DataGrid, GridColDef } from "@mui/x-data-grid";

const rows = [
  {
    id: 1,
    name: "Amazon",
    amount: 2499,
    status: "Completed",
    date: "22 Jul 2026",
  },
  {
    id: 2,
    name: "Netflix",
    amount: 799,
    status: "Completed",
    date: "21 Jul 2026",
  },
  {
    id: 3,
    name: "Electricity Bill",
    amount: 3200,
    status: "Pending",
    date: "20 Jul 2026",
  },
  {
    id: 4,
    name: "Salary",
    amount: 85000,
    status: "Received",
    date: "18 Jul 2026",
  },
];

const columns: GridColDef[] = [
  {
    field: "name",
    headerName: "Transaction",
    flex: 1,
  },
  {
    field: "amount",
    headerName: "Amount",
    flex: 1,
    renderCell: (params) => `₹${params.value.toLocaleString()}`,
  },
  {
    field: "status",
    headerName: "Status",
    flex: 1,
    renderCell: (params) => (
      <Chip
        label={params.value}
        color={
          params.value === "Completed"
            ? "success"
            : params.value === "Pending"
            ? "warning"
            : "primary"
        }
        size="small"
      />
    ),
  },
  {
    field: "date",
    headerName: "Date",
    flex: 1,
  },
];

export default function TransactionTable() {
  return (
    <Card
      sx={{
        borderRadius: 5,
        height: 430,
      }}
    >
      <CardContent>
        <Stack
          direction="row"
          justifyContent="space-between"
          mb={2}
        >
          <Typography
            variant="h6"
            fontWeight={700}
          >
            Recent Transactions
          </Typography>
        </Stack>

        <DataGrid
          rows={rows}
          columns={columns}
          disableRowSelectionOnClick
          hideFooter
        />
      </CardContent>
    </Card>
  );
}