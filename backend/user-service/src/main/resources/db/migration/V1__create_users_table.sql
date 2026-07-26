CREATE TABLE users
(
    id UUID PRIMARY KEY,

    keycloak_id VARCHAR(100) NOT NULL UNIQUE,

    email VARCHAR(255) NOT NULL UNIQUE,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    phone VARCHAR(20),
    gender VARCHAR(20) NOT NULL,

    status VARCHAR(20) NOT NULL,

    kyc_status VARCHAR(20) NOT NULL,

    created_at TIMESTAMP,

    updated_at TIMESTAMP
);