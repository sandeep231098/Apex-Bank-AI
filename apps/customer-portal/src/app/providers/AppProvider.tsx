import type { ReactNode } from "react";

import CssBaseline from "@mui/material/CssBaseline";
import { ThemeProvider } from "@mui/material/styles";

import { Provider } from "react-redux";

import {
  QueryClient,
  QueryClientProvider,
} from "@tanstack/react-query";

import { appTheme } from "@/app/theme";
import { store } from "@/app/store/store";

const queryClient = new QueryClient();

type Props = {
  children: ReactNode;
};

export default function AppProvider({ children }: Props) {
  return (
    <Provider store={store}>
      <QueryClientProvider client={queryClient}>
        <ThemeProvider theme={appTheme}>
          <CssBaseline />
          {children}
        </ThemeProvider>
      </QueryClientProvider>
    </Provider>
  );
}