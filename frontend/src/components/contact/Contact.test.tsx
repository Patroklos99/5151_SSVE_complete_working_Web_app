import { render, screen } from "@testing-library/react";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import Contact from "./Contact";

test("Should renders the contact page", () => {
  render(<Contact />, { wrapper: BrowserRouter });
  const title = screen.getByText(/Contact/i, { selector: "h1" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
