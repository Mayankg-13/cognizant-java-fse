# PL/SQL Stored Procedures

This project demonstrates the implementation of PL/SQL stored procedures in a banking database context to automate monthly interest calculation, update employee salaries with department-specific performance bonuses, and transfer funds between customer accounts using secure transaction control.

## 1. Database Schema

The database consists of three tables: `Customers`, `Accounts`, and `Employees`.

```sql
-- Create Customers table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Balance NUMBER,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

-- Create Accounts table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastUpdate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create Employees table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER,
    HireDate DATE
);
```

---

## 2. Scenarios and Implementations

### Scenario 1: Process Monthly Interest for Savings Accounts
Create a stored procedure `ProcessMonthlyInterest` that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

- **File:** [Scenario1.sql](./Scenario1.sql)
- **Implementation Highlights:**
  - Uses a cursor with `FOR UPDATE OF Balance` to safely lock each row during modification.
  - Updates `Balance` and `LastUpdate` timestamps.
  - Executes a `COMMIT` to persist changes.

```sql
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    CURSOR c_savings IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
        FOR UPDATE OF Balance;
BEGIN
    FOR r_savings IN c_savings LOOP
        UPDATE Accounts
        SET Balance = Balance * 1.01,
            LastUpdate = SYSDATE
        WHERE CURRENT OF c_savings;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully applied 1% interest to all Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Failed to process monthly interest: ' || SQLERRM);
        RAISE;
END;
/
```

---

### Scenario 2: Update Employee Bonus by Department
Create a stored procedure `UpdateEmployeeBonus` that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

- **File:** [Scenario2.sql](./Scenario2.sql)
- **Implementation Highlights:**
  - Parameterized department name and bonus percentage inputs.
  - Input validation: verifies that the bonus percentage is non-negative.
  - Handles cases where no employees belong to the requested department.

```sql
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPct IN NUMBER
) AS
    v_emp_count NUMBER;
BEGIN
    IF p_BonusPct IS NULL OR p_BonusPct < 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Invalid bonus percentage. It must be non-negative.');
    END IF;
    
    SELECT COUNT(*) INTO v_emp_count
    FROM Employees
    WHERE Department = p_Department;
    
    IF v_emp_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_Department);
        RETURN;
    END IF;
    
    UPDATE Employees
    SET Salary = Salary * (1 + (p_BonusPct / 100))
    WHERE Department = p_Department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully applied ' || p_BonusPct || '% bonus to ' || v_emp_count || ' employees in department ' || p_Department || '.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Failed to update employee bonus: ' || SQLERRM);
        RAISE;
END;
/
```

---

### Scenario 3: Secure Fund Transfers
Create a stored procedure `TransferFunds` that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

- **File:** [Scenario3.sql](./Scenario3.sql)
- **Implementation Highlights:**
  - Input validation for transfer amounts (must be positive) and accounts (must be distinct).
  - **Concurrency Control & Deadlock Prevention**: Locks accounts in a consistent ascending ID sequence using `FOR UPDATE`.
  - Transaction rollbacks (`ROLLBACK`) on errors or missing accounts to ensure atomicity.

```sql
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_SourceAccountID IN NUMBER,
    p_DestAccountID IN NUMBER,
    p_Amount IN NUMBER
) AS
    v_SourceBalance NUMBER;
    v_DestBalance   NUMBER;
BEGIN
    IF p_Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Transfer amount must be greater than zero.');
    END IF;
    
    IF p_SourceAccountID = p_DestAccountID THEN
        RAISE_APPLICATION_ERROR(-20006, 'Source and destination accounts must be different.');
    END IF;
    
    -- Prevent deadlocks by locking in consistent ascending order
    IF p_SourceAccountID < p_DestAccountID THEN
        SELECT Balance INTO v_SourceBalance FROM Accounts WHERE AccountID = p_SourceAccountID FOR UPDATE;
        SELECT Balance INTO v_DestBalance FROM Accounts WHERE AccountID = p_DestAccountID FOR UPDATE;
    ELSE
        SELECT Balance INTO v_DestBalance FROM Accounts WHERE AccountID = p_DestAccountID FOR UPDATE;
        SELECT Balance INTO v_SourceBalance FROM Accounts WHERE AccountID = p_SourceAccountID FOR UPDATE;
    END IF;
    
    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20004, 'Insufficient funds. Account ' || p_SourceAccountID || ' balance is ' || v_SourceBalance || ', requested transfer: ' || p_Amount);
    END IF;
    
    UPDATE Accounts
    SET Balance = Balance - p_Amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_SourceAccountID;
    
    UPDATE Accounts
    SET Balance = Balance + p_Amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_DestAccountID;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred ' || p_Amount || ' from Account ' || p_SourceAccountID || ' to Account ' || p_DestAccountID || '.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20005, 'One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
```

---

## 3. How to Run

1. **Initialize Database and Seed Data:**
   Run `schema.sql` inside your Oracle Database tool (e.g. SQL*Plus, SQL Developer, or DBeaver).
   ```sql
   @schema.sql
   ```
2. **Enable DBMS Output:**
   Ensure console logging is enabled so you can read execution outputs:
   ```sql
   SET SERVEROUTPUT ON;
   ```
3. **Execute & Test Scenario 1 (Process Monthly Interest):**
   ```sql
   @Scenario1.sql
   ```
4. **Execute & Test Scenario 2 (Update Employee Bonus):**
   ```sql
   @Scenario2.sql
   ```
5. **Execute & Test Scenario 3 (Transfer Funds):**
   ```sql
   @Scenario3.sql
   ```

## 4. Execution Output

When executing the test scripts, the output will log the initial states, state transitions, validation checks, and final database states in the server output console.
