-- Drop tables if they exist
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS customer;

-- Create Customer table
CREATE TABLE customer
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    phone         VARCHAR(255) NOT NULL,
    status        VARCHAR(10)  NOT NULL DEFAULT 'ACTIVE',
    date_of_birth DATE         NOT NULL,
    address       VARCHAR(255) NOT NULL
);

-- Create Card table
CREATE TABLE card
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    card_type       VARCHAR(15)  NOT NULL,
    card_number     VARCHAR(255) NOT NULL UNIQUE,
    expiration_date DATE         NOT NULL,
    status          VARCHAR(10)  NOT NULL DEFAULT 'ACTIVE',
    cvv             VARCHAR(4)   NOT NULL,
    customer_id     BIGINT       NOT NULL,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id) REFERENCES customer (id)
);