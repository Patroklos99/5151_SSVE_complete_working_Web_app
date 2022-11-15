import NavBar from "./Header";
import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import Header from "./Header";

test("Should renders the header component", () => {
  render(<Header />, { wrapper: BrowserRouter });
  const header = screen.getByTestId("header");
  expect(header).toBeInTheDocument();
});

test("Should renders the navigation component", () => {
  render(<NavBar />, { wrapper: BrowserRouter });
  const nav = screen.getByTestId("nav");
  expect(nav).toBeInTheDocument();
});

test("Should have 4 links in the navigation bar", () => {
  render(<NavBar />, { wrapper: BrowserRouter });
  const navBar = screen.getAllByRole("link");
  expect(navBar.length).toEqual(4);
});
