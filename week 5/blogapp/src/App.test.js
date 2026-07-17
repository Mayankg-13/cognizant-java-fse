import { render, screen } from '@testing-library/react';
import App from './App';

test('renders welcome to the posts list header', () => {
  render(<App />);
  const headerElement = screen.getByText(/Welcome to the Posts List/i);
  expect(headerElement).toBeInTheDocument();
});
