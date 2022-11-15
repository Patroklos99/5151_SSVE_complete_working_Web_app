import { render, screen } from "@testing-library/react";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import ResultsList from ".";

test("Should renders the ResultsList component", async () => {
  render(<ResultsList />, { wrapper: BrowserRouter });
  const title = screen.getByText(/Résultats/i, { selector: "h2" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
