import { render, screen } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import { BrowserRouter } from "react-router-dom";
import App from "./App";

test("Should renders the app", () => {
  render(<App />, { wrapper: BrowserRouter });
  const app = screen.getByTestId("app");
  expect(app).not.toBeNull();
  expect(app).toBeInTheDocument();
});

test("Should redirect to dashboard page", async () => {
  const user = userEvent.setup();
  render(<App />, { wrapper: BrowserRouter });

  await user.click(screen.getByText(/Faire le test/i));
  const dashboard = screen.getByText(/Dashboard/i, { selector: "h1" });
  expect(dashboard).toBeInTheDocument();
});

test("Should redirect to contact page", async () => {
  const user = userEvent.setup();
  render(<App />, { wrapper: BrowserRouter });

  await user.click(screen.getByText(/Contact/i));
  const contact = screen.getByText(/Contact/i, { selector: "h1" });
  expect(contact).toBeInTheDocument();
});

// TODO: make Contact page
test.skip("Should redirect to about page", async () => {
  const user = userEvent.setup();
  render(<App />, { wrapper: BrowserRouter });

  await user.click(screen.getByText(/À propos/i));
  const about = screen.getByText(/À propos/i, { selector: "h1" });
  expect(about).toBeInTheDocument();
});
