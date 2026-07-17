import { render, screen } from '@testing-library/react';
import App from './App';

test('renders cohorts details title', () => {
  render(<App />);
  const titleElement = screen.getByText(/Cohorts Details/i);
  expect(titleElement).toBeInTheDocument();
});
