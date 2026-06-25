-- ============================================================
-- Exercise 6: Cursors
-- ============================================================


-- Scenario 1: Print monthly statement for each customer using an explicit cursor

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, t.TransactionID, t.TransactionDate,
               t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a  ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');

    rec GenerateMonthlyStatements%ROWTYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO rec;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name
            || ' | TxnID: ' || rec.TransactionID
            || ' | Date: '  || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY')
            || ' | Type: '  || rec.TransactionType
            || ' | Amount: ' || rec.Amount);
    END LOOP;
    CLOSE GenerateMonthlyStatements;
END;
/


-- Scenario 2: Deduct an annual maintenance fee from every account

DECLARE
    v_annual_fee CONSTANT NUMBER := 100;  -- fee amount

    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;

    rec ApplyAnnualFee%ROWTYPE;
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO rec;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance      = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('AccountID: ' || rec.AccountID
            || ' | Fee deducted. New Balance: ' || (rec.Balance - v_annual_fee));
    END LOOP;
    CLOSE ApplyAnnualFee;

    COMMIT;
END;
/


-- Scenario 3: Update loan interest rates based on a new policy
--   Policy: rate < 5  → set to 6
--           rate >= 5 → add 0.5

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE;

    rec   UpdateLoanInterestRates%ROWTYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO rec;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        IF rec.InterestRate < 5 THEN
            v_new_rate := 6;
        ELSE
            v_new_rate := rec.InterestRate + 0.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE('LoanID: ' || rec.LoanID
            || ' | Old Rate: ' || rec.InterestRate
            || ' | New Rate: ' || v_new_rate);
    END LOOP;
    CLOSE UpdateLoanInterestRates;

    COMMIT;
END;
/
