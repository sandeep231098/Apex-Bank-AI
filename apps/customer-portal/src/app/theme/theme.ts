import { createTheme } from "@mui/material/styles";

import { darkPalette } from "./palette";
import typography from "./typography";
import { spacing } from "./spacing";
import { components } from "./components";

export const appTheme = createTheme({
  palette: darkPalette,
  typography,
  spacing,
  components,
});