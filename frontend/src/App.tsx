import { Routes, Route } from "react-router-dom";
import About from "./components/about/About";
import Contact from "./components/contact/Contact";
import Timeline from './components/timeline/timeline';

import Dashboard from "./components/dashboard";
import HomePage from "./components/homepage/HomePage";
import Header from "./components/shared/Header";

function App() {
  return (
    <div className="App" data-testid="app">
      <Header />
      <div className="App-body">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/timeline" element={<Timeline/>}/>
        </Routes>
      </div>

    </div>
  );
}

export default App;
