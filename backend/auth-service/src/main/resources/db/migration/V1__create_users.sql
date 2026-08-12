CREATE TABLE users
(
    id UUID PRIMARY KEY,

    first_name VARCHAR(255) NOT NULL,

    last_name VARCHAR(255) NOT NULL,

    email VARCHAR(255) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    role VARCHAR(50),

    enabled BOOLEAN NOT NULL,

    account_locked BOOLEAN NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);

ALTER TABLE users
    ADD CONSTRAINT chk_users_role
        CHECK (
            role IN (
                     'ROLE_ADMIN',
                     'ROLE_MANAGER',
                     'ROLE_CUSTOMER'
                )
            );