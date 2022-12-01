import { render, screen } from "@testing-library/react";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import Dashboard from ".";

test("Should renders the dashboard page", () => {
  render(<Dashboard />, { wrapper: BrowserRouter });
  const title = screen.getByText(/Dashboard/i, { selector: "h1" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
