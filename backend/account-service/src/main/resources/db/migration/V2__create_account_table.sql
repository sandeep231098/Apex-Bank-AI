CREATE TABLE accounts
(
    id UUID PRIMARY KEY,

    user_id UUID NOT NULL,

    account_number VARCHAR(20) NOT NULL UNIQUE,

    account_type VARCHAR(30) NOT NULL,

    account_status VARCHAR(30) NOT NULL,

    balance NUMERIC(19,2) NOT NULL,

    currency VARCHAR(3) NOT NULL,

    branch_code VARCHAR(20) NOT NULL,

    ifsc_code VARCHAR(20) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_accounts_user_id
    ON accounts(user_id);

CREATE INDEX idx_accounts_number
    ON accounts(account_number);