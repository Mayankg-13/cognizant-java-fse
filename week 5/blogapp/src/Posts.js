import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then(data => {
        // Use custom simple English posts to replace the default Latin placeholder text
        const customPosts = [
          { id: 1, title: "My first blog post", body: "Hello everyone! This is my first simple blog post." },
          { id: 2, title: "Learning React is fun", body: "React is very interesting. I like components and life cycles." },
          { id: 3, title: "A nice sunny day", body: "Today the weather is very warm and pleasant outside." }
        ];
        const posts = customPosts.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts });
      })
      .catch(error => {
        alert("Error: " + error.message);
        this.setState({ error });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("Error occurred: " + error.message);
    this.setState({ error });
  }

  render() {
    if (this.state.error) {
      return <div>Something went wrong: {this.state.error.message}</div>;
    }
    return (
      <div>
        <h1>Welcome to the Posts List</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: '1px solid #ccc', margin: '10px 0', paddingBottom: '10px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
