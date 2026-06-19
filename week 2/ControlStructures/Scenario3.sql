DECLARE
    CURSOR c_due_loans IS
        SELECT c.Name, l.LoanID, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ' has loan ' || rec.LoanID || ' due on ' || TO_CHAR(rec.DueDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
