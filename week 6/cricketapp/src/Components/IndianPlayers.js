import React from 'react';

export function OddPlayers([first, , third, , fifth]) {
  return (
    <div className="destructured-players">
      <li> First : {first} </li>
      <li> Third : {third} </li>
      <li> Fifth : {fifth} </li>
    </div>
  );
}

export function EvenPlayers([, second, , fourth, , sixth]) {
  return (
    <div className="destructured-players">
      <li> Second : {second} </li>
      <li> Fourth : {fourth} </li>
      <li> Sixth : {sixth} </li>
    </div>
  );
}

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <div className="player-list-container">
      {IndianPlayers.map((item) => {
        return (
          <div key={item} className="player-item">
            <li>Mr. {item}</li>
          </div>
        );
      })}
    </div>
  );
}
