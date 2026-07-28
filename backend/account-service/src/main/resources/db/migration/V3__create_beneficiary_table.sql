CREATE TABLE beneficiaries (

                               id UUID PRIMARY KEY,

                               customer_id UUID NOT NULL,

                               beneficiary_name VARCHAR(150) NOT NULL,

                               beneficiary_account_number VARCHAR(30) NOT NULL,

                               beneficiary_ifsc VARCHAR(20) NOT NULL,

                               nickname VARCHAR(100),

                               status VARCHAR(20) NOT NULL,

                               verified BOOLEAN NOT NULL DEFAULT FALSE,

                               created_at TIMESTAMP NOT NULL,

                               updated_at TIMESTAMP NOT NULL

);