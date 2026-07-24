import React, { useState } from 'react';
import './App.css';
import { ListofPlayers, Scorebelow70 } from './Components/ListofPlayers';
import { OddPlayers, EvenPlayers, ListofIndianPlayers } from './Components/IndianPlayers';

// 1. ListofPlayers Data
const players = [
  { name: 'Jack', score: 50 },
  { name: 'Michael', score: 70 },
  { name: 'John', score: 40 },
  { name: 'Ann', score: 61 },
  { name: 'Elisabeth', score: 61 },
  { name: 'Sachin', score: 95 },
  { name: 'Dhoni', score: 100 },
  { name: 'Virat', score: 84 },
  { name: 'Jadeja', score: 94 },
  { name: 'Raina', score: 75 },
  { name: 'Rohit', score: 80 }
];

// 2. IndianPlayers Data
const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvraj5', 'Raina6'];

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
// Merge using spread operator
const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

function App() {
  const [flag, setFlag] = useState(true);

  if (flag === true) {
    return (
      <div className="App">
        <div className="controls">
          <button className="toggle-btn" onClick={() => setFlag(false)}>
            Switch to Flag = false
          </button>
        </div>
        <div className="content-card">
          <h1>List of Players</h1>
          <ListofPlayers players={players} />
          <hr className="divider" />
          <h1>List of Players having Scores Less than 70</h1>
          <Scorebelow70 players={players} />
        </div>
      </div>
    );
  } else {
    return (
      <div className="App">
        <div className="controls">
          <button className="toggle-btn" onClick={() => setFlag(true)}>
            Switch to Flag = true
          </button>
        </div>
        <div className="content-card">
          <div>
            <h1>Indian Team</h1>
            <h2>Odd Players</h2>
            {OddPlayers(IndianTeam)}
            <hr className="divider" />
            <h2>Even Players</h2>
            {EvenPlayers(IndianTeam)}
          </div>
          <hr className="divider" />
          <div>
            <h1>List of Indian Players Merged:</h1>
            <ListofIndianPlayers IndianPlayers={IndianPlayers} />
          </div>
        </div>
      </div>
    );
  }
}

export default App;
