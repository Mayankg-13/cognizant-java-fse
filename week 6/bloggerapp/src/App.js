import React, { useState } from 'react';
import './App.css';
import BookDetails from './Components/BookDetails';
import CourseDetails from './Components/CourseDetails';
import BlogDetails from './Components/BlogDetails';

const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 }
];

const courses = [
  { id: 1, cname: 'Angular', startdate: '4/5/2021' },
  { id: 2, cname: 'React', startdate: '6/3/2020' }
];

const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz', desc: 'Welcome to learning React!!' },
  { id: 2, title: 'Installation', author: 'Schoolofdev', desc: 'You can install React from npm.' }
];

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showCourses, setShowCourses] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  // 1. Element Variable conditional rendering method
  let bookdet = null;
  if (showBooks) {
    bookdet = <BookDetails books={books} />;
  }

  // 2. JSX element prepared for Logical && rendering method
  const content = <BlogDetails blogs={blogs} />;

  // 3. JSX element prepared for Ternary rendering method
  const coursedet = <CourseDetails courses={courses} />;

  return (
    <div className="App">
      {/* Visibility control panel */}
      <div className="control-panel">
        <h3>Conditional Rendering Controls:</h3>
        <div className="toggles">
          <label>
            <input 
              type="checkbox" 
              checked={showCourses} 
              onChange={() => setShowCourses(!showCourses)} 
            />
            Show Course Details (Ternary Method)
          </label>
          <label>
            <input 
              type="checkbox" 
              checked={showBooks} 
              onChange={() => setShowBooks(!showBooks)} 
            />
            Show Book Details (Element Variable Method)
          </label>
          <label>
            <input 
              type="checkbox" 
              checked={showBlogs} 
              onChange={() => setShowBlogs(!showBlogs)} 
            />
            Show Blog Details (Logical && Method)
          </label>
        </div>
      </div>

      {/* Main layout matching the mystyle1, st2, and v1 structure */}
      <div className="dashboard-layout">
        <div className="mystyle1">
          <h1>Course Details</h1>
          {/* Method A: Ternary Operator */}
          {showCourses ? coursedet : null}
        </div>
        
        <div className="st2">
          <h1>Book Details</h1>
          {/* Method B: Element Variable */}
          {bookdet}
        </div>
        
        <div className="v1">
          <h1>Blog Details</h1>
          {/* Method C: Logical && Short-Circuit */}
          {showBlogs && content}
        </div>
      </div>
    </div>
  );
}

export default App;
