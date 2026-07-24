import React, { useState } from 'react';
import './App.css';
import FlightBooking from './Components/FlightBooking';

// Helper button components from prompt hint
function LoginButton(props) {
  return (
    <button onClick={props.onClick} className="btn btn-login">
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick} className="btn btn-logout">
      Logout
    </button>
  );
}

// Helper greeting components from prompt hint
function GuestGreeting() {
  return <h1>Please sign up.</h1>;
}

function UserGreeting() {
  return <h1>Welcome back</h1>;
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // Using element variables for conditional rendering (Objective 2)
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div className="App">
      <div className="booking-portal">
        <header className="portal-header">
          <div className="greeting-area">
            <Greeting isLoggedIn={isLoggedIn} />
          </div>
          <div className="action-area">
            {button}
          </div>
        </header>

        <main className="portal-main">
          <FlightBooking isLoggedIn={isLoggedIn} />
        </main>
      </div>
    </div>
  );
}

export default App;
