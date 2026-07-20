import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

type Props = {
  title: string;
  subtitle?: string;
};

export default function SectionHeader({
  title,
  subtitle,
}: Props) {
  return (
    <Box mb={3}>
      <Typography
        variant="h4"
        fontWeight={700}
      >
        {title}
      </Typography>

      {subtitle && (
        <Typography
          color="text.secondary"
          mt={1}
        >
          {subtitle}
        </Typography>
      )}
    </Box>
  );
}