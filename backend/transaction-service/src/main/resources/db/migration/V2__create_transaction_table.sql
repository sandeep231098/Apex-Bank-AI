CREATE TABLE transactions
(
    id UUID PRIMARY KEY,

    transaction_reference VARCHAR(50) NOT NULL UNIQUE,

    from_account_id UUID NOT NULL,

    to_account_id UUID,

    transaction_type VARCHAR(30) NOT NULL,

    transaction_status VARCHAR(30) NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    remarks VARCHAR(255),

    created_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_transaction_reference
    ON transactions(transaction_reference);

CREATE INDEX idx_from_account
    ON transactions(from_account_id);

CREATE INDEX idx_to_account
    ON transactions(to_account_id);