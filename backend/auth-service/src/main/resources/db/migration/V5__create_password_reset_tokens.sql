CREATE TABLE password_reset_tokens
(
    id UUID PRIMARY KEY,

    token VARCHAR(255) UNIQUE NOT NULL,

    user_id BIGINT NOT NULL,

    expiry_date TIMESTAMP NOT NULL,

    used BOOLEAN NOT NULL,

    CONSTRAINT fk_password_reset_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)
);