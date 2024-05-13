import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import { MantineProvider } from "@mantine/core";
import App from "./App.jsx";
import "@mantine/core/styles.css";

ReactDOM.createRoot(document.getElementById("root")).render(
	<React.StrictMode>
		<BrowserRouter>
			<MantineProvider defaultColorScheme="dark">
				<App />
			</MantineProvider>
		</BrowserRouter>
	</React.StrictMode>,
)
