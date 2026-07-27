CREATE TABLE daily_transfer_limits
(
    id UUID PRIMARY KEY,

    account_id UUID NOT NULL,

    transfer_date DATE NOT NULL,

    total_transferred NUMERIC(19,2) NOT NULL
);

CREATE UNIQUE INDEX idx_daily_transfer
    ON daily_transfer_limits(account_id, transfer_date);