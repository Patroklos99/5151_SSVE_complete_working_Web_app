import { render, screen } from "@testing-library/react";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import ResultsList from ".";
import ICar from "../../../types/Car";

const handleResultClick = (result: ICar) => {
  console.log(result);

}


test("Should renders the ResultsList component", () => {
  render(<ResultsList handleResultClick = {()=> null}/>, { wrapper: BrowserRouter });
  const title = screen.getByText(/Résultats/i, { selector: "h2" });
  expect(title).not.toBeNull();
  expect(title).toBeInTheDocument();
});
