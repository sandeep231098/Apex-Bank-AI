CREATE TABLE transaction_request_logs
(
    id UUID PRIMARY KEY,

    request_id VARCHAR(100) UNIQUE NOT NULL,

    transaction_id UUID NOT NULL,

    created_at TIMESTAMP NOT NULL
);