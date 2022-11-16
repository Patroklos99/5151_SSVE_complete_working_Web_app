import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import About from "./About";

test("Should renders the about page", () => {
  render(<About />, { wrapper: BrowserRouter });
  const title = screen.getByText(/À propos/i, { selector: "h1" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
