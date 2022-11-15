import { Routes, Route } from "react-router-dom";
import Contact from "./components/contact/Contact";

import Dashboard from "./components/dashboard";
import HomePage from "./components/homepage/HomePage";
import Input from "./components/input/Input";
import Header from "./components/shared/Header";

function App() {
  return (
    <div className="App" data-testid="app">
      <Header />
      <div className="App-body">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/Input" element={<Input />} />
          <Route path="/Contact" element={<Contact />} />
          <Route path="/Dashboard" element={<Dashboard />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
