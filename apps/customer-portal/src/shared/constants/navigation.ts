import DashboardRoundedIcon from "@mui/icons-material/DashboardRounded";
import AccountBalanceWalletRoundedIcon from "@mui/icons-material/AccountBalanceWalletRounded";
import CreditCardRoundedIcon from "@mui/icons-material/CreditCardRounded";
import CurrencyExchangeRoundedIcon from "@mui/icons-material/CurrencyExchangeRounded";
import AccountBalanceRoundedIcon from "@mui/icons-material/AccountBalanceRounded";
import SmartToyRoundedIcon from "@mui/icons-material/SmartToyRounded";
import SettingsRoundedIcon from "@mui/icons-material/SettingsRounded";

export const navigation = [
  {
    title: "Dashboard",
    icon: DashboardRoundedIcon,
    path: "/",
  },
  {
    title: "Accounts",
    icon: AccountBalanceWalletRoundedIcon,
    path: "/accounts",
  },
  {
    title: "Cards",
    icon: CreditCardRoundedIcon,
    path: "/cards",
  },
  {
    title: "Transfers",
    icon: CurrencyExchangeRoundedIcon,
    path: "/transfers",
  },
  {
    title: "Loans",
    icon: AccountBalanceRoundedIcon,
    path: "/loans",
  },
  {
    title: "AI Assistant",
    icon: SmartToyRoundedIcon,
    path: "/assistant",
  },
  {
    title: "Settings",
    icon: SettingsRoundedIcon,
    path: "/settings",
  },
];