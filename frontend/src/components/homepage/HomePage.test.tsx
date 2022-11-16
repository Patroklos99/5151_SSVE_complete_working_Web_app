import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import HomePage from "./HomePage";

test("Should renders the home page", () => {
  render(<HomePage />, { wrapper: BrowserRouter });
  const title = screen.getByText(/Accueil/i, { selector: "h1" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
