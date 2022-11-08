import { Routes, Route } from "react-router-dom";
import './App.css';

import Dashboard from './components/dashboard';
import AddCar from "./components/example2/example2";
import CarList from './components/example3/example3';

function App() {
  return (
    <div className="App">
      <div className="App-header">
      </div>
      <div className='App-body'>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/add" element={<AddCar />} />
          <Route path="/get" element={<CarList />} />
        </Routes>
      </div>

    </div>

  );
}

export default App;
