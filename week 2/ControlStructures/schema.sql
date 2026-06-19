CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    DOB DATE,
    Balance NUMBER,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1955-05-12', 'YYYY-MM-DD'), 5000, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1985-08-20', 'YYYY-MM-DD'), 12000, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (3, 'Bob Johnson', TO_DATE('1945-11-30', 'YYYY-MM-DD'), 15000, 'FALSE');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (101, 1, 50000, 8.5, SYSDATE + 15);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (102, 2, 20000, 6.0, SYSDATE + 45);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, DueDate)
VALUES (103, 3, 30000, 7.5, SYSDATE + 10);

COMMIT;
