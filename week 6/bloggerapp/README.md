# Week 6 - Exercise 5: Blogger App (Lists, Keys & Conditional Rendering in React)

## Objectives & Core Concepts (Short Answers)

### 1. Explain various ways of conditional rendering
There are several ways to implement conditional rendering in React:
- **Ternary Operator (`condition ? x : y`)**: Inline evaluation of either expression depending on the truthiness of the condition.
- **Logical AND Operator (`condition && x`)**: Short-circuit operator where if the condition is true, it renders `x`, and if false, it renders nothing.
- **Element Variables (`let element; if(...) { element = x; }`)**: Storing React elements in local variables and embedding them in the JSX return block.
- **If/Else Statements**: Standard JavaScript if/else branches placed outside the return statement.
- **Switch Case Statements**: Used to switch rendering components based on state types.

### 2. Explain how to render multiple components
- Multiple components can be rendered side-by-side inside parent containers (like `div`) or React fragments (`<>...</>`). They are imported into a parent component and arranged standardly within its return block.

### 3. Define list component
- **List Component**: A component designed to receive an array of data as props, loop over the array, and dynamically render a collection of sibling elements (usually lists, tables, or cards) representing each item in the array.

### 4. Explain about keys in React applications
- **Keys**: Special string attributes that must be included when creating lists of elements. Keys help React identify which items have changed, been added, or been removed. They give the elements a stable identity, allowing React to optimize performance and prevent state mismatch issues.

### 5. Explain how to extract components with keys
- When extracting a list item as a separate component, the key must be specified on the custom component elements in the loop, **not** on the root element inside the extracted component itself.
  ```javascript
  // Correct
  {items.map(item => <MyListItem key={item.id} data={item} />)}
  ```

### 6. Explain React Map, map() function
- The standard array `map()` method is used to iterate over a data collection and transform each item into a React node. In JSX, wrapping `map()` in curly braces allows React to automatically unpack and render the resulting array of element nodes in the DOM.

---

## Hands-On Lab Outcomes
In this hands-on lab, we learned how to:
- Render multiple sub-components (`BookDetails`, `CourseDetails`, `BlogDetails`) side-by-side in columns.
- Use mapping functions (`map()`) to loop through object arrays and format listings with unique keys.
- Demonstrate multiple conditional rendering methodologies (Element Variables, Ternary logic, and Logical short-circuiting) connected to top-level checkboxes.
- Format side-by-side layouts with green vertical border lines.

## Output Screenshot
![Output Screenshot](./bloggerapp_screenshot.png)
