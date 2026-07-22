import { useAppSelector } from "./useAppSelector";

import {
  selectAuth,
} from "@/app/store/selectors/authSelectors";

export function useAuth() {
  return useAppSelector(selectAuth);
}