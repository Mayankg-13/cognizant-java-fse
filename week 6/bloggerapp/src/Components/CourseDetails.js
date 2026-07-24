import React from 'react';

export default function CourseDetails({ courses }) {
  return (
    <ul>
      {courses.map((course) => (
        <div key={course.id} className="course-item">
          <h3>{course.cname}</h3>
          <h4>{course.startdate}</h4>
        </div>
      ))}
    </ul>
  );
}
