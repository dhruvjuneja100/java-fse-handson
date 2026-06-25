-- ============================================================
-- Exercise 4: Functions
-- ============================================================


-- Scenario 1: Calculate a customer's age in years from their date of birth

CREATE OR REPLACE FUNCTION CalculateAge(p_dob IN DATE)
RETURN NUMBER AS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;
/

-- Usage
-- SELECT CalculateAge(DOB) AS Age FROM Customers;


-- Scenario 2: Compute monthly loan installment using the standard EMI formula
--   EMI = P * r * (1+r)^n / ((1+r)^n - 1)
--   where r = monthly rate, n = total months

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount   IN NUMBER,
    p_interest_rate IN NUMBER,   -- annual percentage, e.g. 12 for 12%
    p_duration_years IN NUMBER
) RETURN NUMBER AS
    v_monthly_rate   NUMBER;
    v_num_months     NUMBER;
    v_emi            NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / (12 * 100);
    v_num_months   := p_duration_years * 12;

    -- Standard EMI formula
    v_emi := p_loan_amount
             * v_monthly_rate
             * POWER(1 + v_monthly_rate, v_num_months)
             / (POWER(1 + v_monthly_rate, v_num_months) - 1);

    RETURN ROUND(v_emi, 2);
END CalculateMonthlyInstallment;
/

-- Usage
-- SELECT CalculateMonthlyInstallment(50000, 10, 5) AS MonthlyEMI FROM DUAL;


-- Scenario 3: Check if an account holds at least a specified amount

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN BOOLEAN AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Account does not exist; treat as insufficient
        RETURN FALSE;
END HasSufficientBalance;
/

-- Usage (PL/SQL only – BOOLEAN cannot be used directly in SQL SELECT)
-- DECLARE
--     v_result BOOLEAN;
-- BEGIN
--     v_result := HasSufficientBalance(1, 500);
--     IF v_result THEN
--         DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
--     ELSE
--         DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
--     END IF;
-- END;
-- /
