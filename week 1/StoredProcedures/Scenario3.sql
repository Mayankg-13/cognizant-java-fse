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
        DBMS_OUTPUT.PUT_LINE('Transfer failed: One or both accounts do not exist.');
        RAISE_APPLICATION_ERROR(-20005, 'One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        RAISE;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    PROCEDURE PrintBalances(p_Msg VARCHAR2) IS
        CURSOR c_accounts IS
            SELECT AccountID, AccountType, Balance
            FROM Accounts
            WHERE AccountID IN (1001, 1002);
    BEGIN
        DBMS_OUTPUT.PUT_LINE(p_Msg);
        FOR r_acc IN c_accounts LOOP
            DBMS_OUTPUT.PUT_LINE('Account ID: ' || r_acc.AccountID || ' | Type: ' || r_acc.AccountType || ' | Balance: ' || r_acc.Balance);
        END LOOP;
    END PrintBalances;
BEGIN
    DBMS_OUTPUT.PUT_LINE('==================================================');
    DBMS_OUTPUT.PUT_LINE('Verify Scenario 3: TransferFunds');
    DBMS_OUTPUT.PUT_LINE('==================================================');
    
    PrintBalances('Balances BEFORE transfer:');
    
    DBMS_OUTPUT.PUT_LINE('--- Case 1: Transferring 1000 from 1002 (Jane) to 1001 (John) ---');
    TransferFunds(1002, 1001, 1000);
    PrintBalances('Balances after Case 1:');
    
    DBMS_OUTPUT.PUT_LINE('--- Case 2: Attempting to transfer 15000 from 1001 (John) to 1002 (Jane) ---');
    BEGIN
        TransferFunds(1001, 1002, 15000);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Exception caught (expected): ' || SQLERRM);
    END;
    
    DBMS_OUTPUT.PUT_LINE('--- Case 3: Attempting to transfer to non-existent account 9999 ---');
    BEGIN
        TransferFunds(1001, 9999, 100);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Exception caught (expected): ' || SQLERRM);
    END;
    DBMS_OUTPUT.PUT_LINE('==================================================');
END;
/
