import React, { useState } from 'react';

export default function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const numAmount = parseFloat(amount);
    
    if (isNaN(numAmount)) {
      alert('Please enter a valid number for amount.');
      return;
    }

    // Conversion logic: Euro to Rupees (multiply by 80)
    // To match the screenshot (Amount: 80, Currency: Euro => Converted: 6400)
    const convertedAmount = numAmount * 80;

    alert(`Converting to Euro. Amount is ${convertedAmount}`);
  };

  return (
    <div className="currency-convertor">
      <h2>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit} className="convertor-form">
        <div className="form-group">
          <label htmlFor="amount">Amount: </label>
          <input
            id="amount"
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="currency">Currency: </label>
          <input
            id="currency"
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="submit-btn">Submit</button>
      </form>
    </div>
  );
}
