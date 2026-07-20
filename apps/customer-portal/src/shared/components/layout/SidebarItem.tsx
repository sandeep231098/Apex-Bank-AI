import type { ElementType } from "react";

import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";

type Props = {
  title: string;
  icon: ElementType;
};

export default function SidebarItem({
  title,
  icon: Icon,
}: Props) {
  return (
    <ListItemButton
      sx={{
        borderRadius: 2,
        mb: 1,
      }}
    >
      <ListItemIcon>
        <Icon color="primary" />
      </ListItemIcon>

      <ListItemText primary={title} />
    </ListItemButton>
  );
}