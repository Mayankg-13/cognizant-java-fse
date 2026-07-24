import React from 'react';

export function ListofPlayers({ players }) {
  return (
    <div className="player-list-container">
      {players.map((item) => {
        return (
          <div key={item.name} className="player-item">
            <li>
              Mr. {item.name} <span> {item.score} </span>
            </li>
          </div>
        );
      })}
    </div>
  );
}

export function Scorebelow70({ players }) {
  // Filter the players with scores below 70 using arrow functions of ES6.
  const players70 = [];
  players.map((item) => {
    if (item.score < 70) {
      players70.push(item);
    }
    return null;
  });

  return (
    <div className="player-list-container">
      {players70.map((item) => {
        return (
          <div key={item.name} className="player-item">
            <li>
              Mr. {item.name} <span> {item.score} </span>
            </li>
          </div>
        );
      })}
    </div>
  );
}
