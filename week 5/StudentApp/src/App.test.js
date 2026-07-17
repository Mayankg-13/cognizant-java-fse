import { render, screen } from '@testing-library/react';
import App from './App';

test('renders student management portal sections', () => {
  render(<App />);
  expect(screen.getByText(/Welcome to the Home Page of Student Management Portal/i)).toBeInTheDocument();
  expect(screen.getByText(/Welcome to the About Page of Student Management Portal/i)).toBeInTheDocument();
  expect(screen.getByText(/Welcome to the Contact Page of Student Management Portal/i)).toBeInTheDocument();
});
