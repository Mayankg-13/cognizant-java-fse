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

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_emp IS
        SELECT EmployeeID, Name, Department, Salary
        FROM Employees;
BEGIN
    DBMS_OUTPUT.PUT_LINE('==================================================');
    DBMS_OUTPUT.PUT_LINE('Verify Scenario 2: UpdateEmployeeBonus');
    DBMS_OUTPUT.PUT_LINE('==================================================');
    
    DBMS_OUTPUT.PUT_LINE('Salaries BEFORE applying bonus:');
    FOR r_emp IN c_emp LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || r_emp.EmployeeID || ' | Name: ' || r_emp.Name || ' | Dept: ' || r_emp.Department || ' | Salary: ' || r_emp.Salary);
    END LOOP;
    
    UpdateEmployeeBonus('IT', 10);
    
    UpdateEmployeeBonus('HR', 5);
    
    DBMS_OUTPUT.PUT_LINE('Salaries AFTER applying bonus:');
    FOR r_emp IN c_emp LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || r_emp.EmployeeID || ' | Name: ' || r_emp.Name || ' | Dept: ' || r_emp.Department || ' | Salary: ' || r_emp.Salary);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Testing input validation with negative bonus (-5%):');
    BEGIN
        UpdateEmployeeBonus('IT', -5);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Exception caught: ' || SQLERRM);
    END;
    DBMS_OUTPUT.PUT_LINE('==================================================');
END;
/
