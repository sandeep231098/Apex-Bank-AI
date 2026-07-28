CREATE TABLE notifications
(
    id UUID PRIMARY KEY,

    recipient VARCHAR(255) NOT NULL,

    subject VARCHAR(255) NOT NULL,

    content TEXT,

    notification_type VARCHAR(30) NOT NULL,

    status VARCHAR(30) NOT NULL,

    error_message TEXT,

    created_at TIMESTAMP NOT NULL,

    sent_at TIMESTAMP
);