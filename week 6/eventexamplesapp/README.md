# Week 6 - Exercise 3: Event Examples App (Event Handling in React)

## Objectives & Core Concepts (Short Answers)

### 1. Explain React events
- **React Events**: React handles events similarly to HTML elements, but uses React's event system rather than standard HTML DOM events. They provide cross-browser wrapper objects that behave identically across Chrome, Firefox, Safari, and Edge.

### 2. Explain about event handlers
- **Event Handlers**: Functions that are executed in response to a user action (like a click, keystroke, or form submission). In React, event handlers are passed as functions rather than strings: `onClick={handleClick}`.

### 3. Define Synthetic event
- **SyntheticEvent**: A cross-browser wrapper around the browser’s native event. It has the same interface as the browser’s native event (including `preventDefault()` and `stopPropagation()`), but works identically across all modern browsers.

### 4. Identify React event naming convention
- React events are named using camelCase instead of lowercase. For example, the HTML click event `onclick` becomes `onClick` in React, and `onsubmit` becomes `onSubmit`.

---

## Hands-On Lab Outcomes
In this hands-on lab, we learned how to:
- Implement event handling concepts in React web applications.
- Invoke multiple methods using a single button click (e.g. Increment button triggers both state increment and alert).
- Bind class/function context and parameters during event execution (e.g. passing `'welcome'` to `handleSayWelcome`).
- Leverage React SyntheticEvents (`onClick`, `onSubmit`) to prevent default browser behavior and process user inputs.

## Output Screenshots
We captured output screenshots demonstrating various button clicks and form submissions:
- Counter Alert (`Hello Member!!`)
- Say Welcome Alert (`welcome`)
- Synthetic click Alert (`I was clicked`)
- Currency Converter Alert (`Converting to Euro. Amount is 6400`)

They are saved inside the project folder:
- **`eventexamplesapp_counter.png`**
- **`eventexamplesapp_welcome.png`**
- **`eventexamplesapp_press.png`**
- **`eventexamplesapp_convert.png`**
