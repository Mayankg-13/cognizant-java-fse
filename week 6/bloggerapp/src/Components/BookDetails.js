import React from 'react';

export default function BookDetails({ books }) {
  return (
    <ul>
      {books.map((book) => (
        <div key={book.id} className="book-item">
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );
}
