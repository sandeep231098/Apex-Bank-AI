CREATE TABLE refresh_tokens
(
    id UUID PRIMARY KEY,

    token VARCHAR(255) UNIQUE NOT NULL,

    user_id BIGINT NOT NULL,

    expiry_date TIMESTAMP NOT NULL,

    revoked BOOLEAN NOT NULL,

    CONSTRAINT fk_refresh_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);