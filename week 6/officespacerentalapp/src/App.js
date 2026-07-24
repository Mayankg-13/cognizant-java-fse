import React from 'react';
import './App.css';
import officeImg from './office_space.png';

const element = "Office Space";
const jsxatt = <img src={officeImg} width="25%" height="25%" alt="Office Space" className="office-img" />;

const officeList = [
  { Name: "DBS", Rent: 50000, Address: "Chennai" },
  { Name: "Regus", Rent: 75000, Address: "Bangalore" },
  { Name: "WeWork", Rent: 60000, Address: "Mumbai" },
  { Name: "Awfis", Rent: 45000, Address: "Hyderabad" },
  { Name: "Innov8", Rent: 65000, Address: "Delhi" }
];

function App() {
  return (
    <div className="App">
      <div className="header-container">
        <h1>{element} , at Affordable Range </h1>
        {jsxatt}
      </div>
      
      <div className="office-list">
        {officeList.map((item, index) => {
          // Inline CSS styling based on rent threshold
          const rentStyle = {
            color: item.Rent <= 60000 ? 'red' : 'green',
            fontWeight: 'bold'
          };
          
          return (
            <div key={index} className="office-card">
              <h1>Name: {item.Name}</h1>
              <h3 style={rentStyle}>Rent: Rs. {item.Rent}</h3>
              <h3>Address: {item.Address}</h3>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;
