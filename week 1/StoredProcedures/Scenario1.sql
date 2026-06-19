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

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_verify IS
        SELECT AccountID, Balance, LastUpdate
        FROM Accounts
        WHERE AccountType = 'Savings';
BEGIN
    DBMS_OUTPUT.PUT_LINE('==================================================');
    DBMS_OUTPUT.PUT_LINE('Verify Scenario 1: ProcessMonthlyInterest');
    DBMS_OUTPUT.PUT_LINE('==================================================');
    
    DBMS_OUTPUT.PUT_LINE('Balances BEFORE applying interest:');
    FOR r_verify IN c_verify LOOP
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || r_verify.AccountID || ' | Balance: ' || r_verify.Balance);
    END LOOP;
    
    ProcessMonthlyInterest;
    
    DBMS_OUTPUT.PUT_LINE('Balances AFTER applying interest:');
    FOR r_verify IN c_verify LOOP
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || r_verify.AccountID || ' | Balance: ' || r_verify.Balance || ' | LastUpdate: ' || TO_CHAR(r_verify.LastUpdate, 'YYYY-MM-DD'));
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('==================================================');
END;
/
