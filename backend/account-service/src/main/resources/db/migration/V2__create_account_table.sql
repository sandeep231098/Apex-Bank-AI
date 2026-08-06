CREATE TABLE accounts
(
    id UUID PRIMARY KEY,

    customer_id UUID NOT NULL,

    account_number VARCHAR(20) NOT NULL UNIQUE,

    account_type VARCHAR(30) NOT NULL,

    status VARCHAR(30) NOT NULL,

    currency VARCHAR(3) NOT NULL,

    balance NUMERIC(19,2) NOT NULL,

    version BIGINT NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_accounts_customer_id
    ON accounts(customer_id);

CREATE INDEX idx_accounts_number
    ON accounts(account_number);