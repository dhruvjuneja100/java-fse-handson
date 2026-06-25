-- ============================================================
-- Exercise 1: Control Structures
-- ============================================================


-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60

DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
                FROM Customers c
                JOIN Loans l ON c.CustomerID = l.CustomerID)
    LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID
                                 || ' | New Rate: ' || (rec.InterestRate - 1));
        END IF;
    END LOOP;

    COMMIT;
END;
/


-- Scenario 2: Mark customers with balance over $10,000 as VIP

DECLARE
    v_flag VARCHAR2(5);
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers)
    LOOP
        IF rec.Balance > 10000 THEN
            v_flag := 'TRUE';
        ELSE
            v_flag := 'FALSE';
        END IF;

        UPDATE Customers
        SET IsVIP = v_flag
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ' | IsVIP: ' || v_flag);
    END LOOP;

    COMMIT;
END;
/


-- Scenario 3: Print reminders for loans due within the next 30 days

BEGIN
    FOR rec IN (SELECT l.LoanID, c.Name, l.EndDate
                FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.Name
                             || ', your loan (ID: ' || rec.LoanID
                             || ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
