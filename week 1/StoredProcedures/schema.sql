BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Balance NUMBER,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastUpdate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER,
    HireDate DATE
);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1955-05-12', 'YYYY-MM-DD'), 5000, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1985-08-20', 'YYYY-MM-DD'), 12000, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (3, 'Bob Johnson', TO_DATE('1945-11-30', 'YYYY-MM-DD'), 15000, 'FALSE');

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1001, 1, 'Savings', 5000, SYSDATE - 30);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1002, 2, 'Savings', 12000, SYSDATE - 30);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1003, 1, 'Checking', 2000, SYSDATE - 15);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1004, 3, 'Savings', 15000, SYSDATE - 30);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1005, 3, 'Checking', 500, SYSDATE - 5);

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (101, 'Alice Johnson', 'IT', 60000, TO_DATE('2020-01-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (102, 'Bob Brown', 'HR', 50000, TO_DATE('2021-03-20', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (103, 'Charlie Green', 'IT', 75000, TO_DATE('2019-06-10', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (104, 'Diana Prince', 'Finance', 90000, TO_DATE('2018-04-01', 'YYYY-MM-DD'));

COMMIT;
