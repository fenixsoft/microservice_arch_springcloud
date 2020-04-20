DROP TABLE wallet IF EXISTS;
DROP TABLE payment IF EXISTS;

CREATE TABLE wallet
(
    id         INTEGER IDENTITY PRIMARY KEY,
    money      DECIMAL,
    account_id INTEGER
);

CREATE TABLE payment
(
    id           INTEGER IDENTITY PRIMARY KEY,
    pay_id       VARCHAR(100),
    create_time  DATETIME,
    total_price  DECIMAL,
    expires      INTEGER NOT NULL,
    payment_link VARCHAR(300),
    pay_state    VARCHAR(20)
);
