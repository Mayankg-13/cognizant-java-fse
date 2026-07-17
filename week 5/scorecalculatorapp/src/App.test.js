import { render, screen } from '@testing-library/react';
import App from './App';

test('renders student details and calculated score', () => {
  render(<App />);
  expect(screen.getByText(/Student Details:/i)).toBeInTheDocument();
  expect(screen.getByText(/Name:/i)).toBeInTheDocument();
  expect(screen.getByText(/Shreya/i)).toBeInTheDocument();
  expect(screen.getByText(/School:/i)).toBeInTheDocument();
  expect(screen.getByText(/DAV Public School/i)).toBeInTheDocument();
  expect(screen.getByText(/Total:/i)).toBeInTheDocument();
  expect(screen.getByText(/284/i)).toBeInTheDocument();
  expect(screen.getByText(/Score:/i)).toBeInTheDocument();
  expect(screen.getByText(/94.67%/i)).toBeInTheDocument();
});
