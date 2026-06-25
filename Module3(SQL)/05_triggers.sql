-- ============================================================
-- Exercise 5: Triggers
-- ============================================================


-- Scenario 1: Auto-update LastModified on any Customers row update

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/


-- Scenario 2: Write an audit record whenever a transaction is inserted

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate,
            :NEW.Amount, :NEW.TransactionType);
END LogTransaction;
/


-- Scenario 3: Validate deposit/withdrawal rules before inserting a transaction
--   - Deposits must have a positive amount
--   - Withdrawals must not exceed the current account balance

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be greater than zero.');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002,
                'Withdrawal of ' || :NEW.Amount || ' exceeds account balance of ' || v_balance);
        END IF;
    END IF;
END CheckTransactionRules;
/
