import React from 'react';

export default function BlogDetails({ blogs }) {
  return (
    <div>
      {blogs.map((blog) => (
        <div key={blog.id} className="blog-item">
          <h3>{blog.title}</h3>
          <h5>{blog.author}</h5>
          <p>{blog.desc}</p>
        </div>
      ))}
    </div>
  );
}
