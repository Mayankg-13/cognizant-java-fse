import React, { useState } from 'react';
import './App.css';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  const [count, setCount] = useState(1);

  const incrementCount = () => {
    setCount((prev) => prev + 1);
  };

  const sayHello = () => {
    alert('Hello Member!!');
  };

  // Button 'Increment' invokes multiple methods: to increment value and to say hello
  const handleIncrement = () => {
    incrementCount();
    sayHello();
  };

  const handleDecrement = () => {
    setCount((prev) => prev - 1);
  };

  const handleSayWelcome = (message) => {
    alert(message);
  };

  // Synthetic event handler
  const handleOnPress = (event) => {
    alert('I was clicked');
  };

  return (
    <div className="App">
      <div className="event-dashboard">
        <div className="counter-container">
          <h1 className="counter-value">{count}</h1>
          
          <div className="button-group">
            <button onClick={handleIncrement} className="btn btn-primary">
              Increment
            </button>
            <button onClick={handleDecrement} className="btn btn-secondary">
              Decrement
            </button>
            <button onClick={() => handleSayWelcome('welcome')} className="btn btn-success">
              Say welcome
            </button>
            <button onClick={handleOnPress} className="btn btn-info">
              Click on me
            </button>
          </div>
        </div>

        <hr className="divider" />

        <CurrencyConvertor />
      </div>
    </div>
  );
}

export default App;
