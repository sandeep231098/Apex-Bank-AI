import { Provider } from "react-redux";
import { Toaster } from "react-hot-toast";

import { store } from "../store/store";

type Props = {
  children: React.ReactNode;
};

export default function AppProvider({
  children,
}: Props) {
  return (
    <Provider store={store}>
      {children}

      <Toaster
        position="top-right"
        reverseOrder={false}
      />
    </Provider>
  );
}