CREATE TABLE beneficiaries
(
    id UUID PRIMARY KEY,

    customer_id UUID NOT NULL,

    beneficiary_name VARCHAR(150) NOT NULL,

    beneficiary_account_number VARCHAR(30) NOT NULL,

    beneficiary_ifsc VARCHAR(20) NOT NULL,

    beneficiary_account_id UUID,

    nickname VARCHAR(100),

    status VARCHAR(30) NOT NULL,

    verified BOOLEAN NOT NULL DEFAULT FALSE,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_beneficiary_customer
    ON beneficiaries(customer_id);

CREATE INDEX idx_beneficiary_account_number
    ON beneficiaries(beneficiary_account_number);

CREATE UNIQUE INDEX idx_customer_beneficiary
    ON beneficiaries(customer_id, beneficiary_account_number);