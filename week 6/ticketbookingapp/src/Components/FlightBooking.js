import React, { useState } from 'react';

const availableFlights = [
  { id: 'FL101', airline: 'Air India', from: 'Chennai', to: 'Delhi', time: '10:30 AM', price: '₹4,500' },
  { id: 'FL202', airline: 'IndiGo', from: 'Bangalore', to: 'Mumbai', time: '02:15 PM', price: '₹3,800' },
  { id: 'FL303', airline: 'SpiceJet', from: 'Kolkata', to: 'Chennai', time: '06:45 PM', price: '₹5,200' },
  { id: 'FL404', airline: 'Vistara', from: 'Delhi', to: 'Bangalore', time: '09:00 PM', price: '₹6,100' }
];

export default function FlightBooking({ isLoggedIn }) {
  const [bookedFlight, setBookedFlight] = useState(null);

  const handleBookTicket = (flightId) => {
    setBookedFlight(flightId);
    alert(`Ticket Booked Successfully for Flight ${flightId}!`);
  };

  return (
    <div className="flight-booking-container">
      <h2>Available Flight Details</h2>
      <div className="flight-list">
        {availableFlights.map((flight) => (
          <div key={flight.id} className="flight-card">
            <div className="flight-info">
              <span className="airline">{flight.airline}</span>
              <span className="flight-id">{flight.id}</span>
              <div className="route">
                <strong>{flight.from}</strong> ➔ <strong>{flight.to}</strong>
              </div>
              <div className="time">Departure: {flight.time}</div>
              <div className="price">{flight.price}</div>
            </div>
            <div className="flight-action">
              {isLoggedIn ? (
                <button 
                  className="book-btn"
                  onClick={() => handleBookTicket(flight.id)}
                  disabled={bookedFlight === flight.id}
                >
                  {bookedFlight === flight.id ? 'Booked' : 'Book Ticket'}
                </button>
              ) : (
                <button className="book-btn disabled" disabled>
                  Sign In to Book
                </button>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
