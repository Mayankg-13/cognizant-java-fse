# Week 6 - Exercise 4: Ticket Booking App (Conditional Rendering in React)

## Objectives & Core Concepts (Short Answers)

### 1. Explain about conditional rendering in React
- **Conditional Rendering**: The ability to render different UI elements or components dynamically based on certain state variables or props. It works similarly to conditional statements in standard JavaScript (e.g. `if`, ternary operators `? :`, or logical `&&` short-circuits).

### 2. Define element variables
- **Element Variables**: Variables that store React elements (like JSX markup). This allows developers to conditionally prepare components or buttons in JavaScript logic and then embed the variable inside the JSX return block:
  ```javascript
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }
  // In return statement:
  return <div>{button}</div>;
  ```

### 3. Explain how to prevent components from rendering
- To prevent a component from rendering completely, make it return `null` instead of JSX. Even if the component is mounted or called, returning `null` tells React to draw nothing on the screen, without affecting its lifecycle methods.

---

## Hands-On Lab Outcomes
In this hands-on lab, we learned how to:
- Implement conditional rendering inside React application setups.
- Declare and use element variables (e.g. `let button;`) to dynamically render buttons based on login state.
- Create multi-profile application views:
  - **Guest View**: Allows users to only browse flight listings (booking buttons are disabled with a sign-up prompt).
  - **Logged-in User View**: Permits flight booking (activates the "Book Ticket" click handler and alerts a booking success confirmation).

## Output Screenshots
We captured output screenshots demonstrating the conditional rendering views:
- **`ticketbookingapp_guest.png`**: The Guest landing view displaying "Please sign up." with the Login button.
- **`ticketbookingapp_user.png`**: The User landing view displaying "Welcome back" with the Logout button and active booking actions.

Both screenshots are saved in the project root directory.
