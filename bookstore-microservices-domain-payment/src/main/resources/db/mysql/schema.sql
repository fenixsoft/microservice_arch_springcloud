DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS wallet;

CREATE TABLE IF NOT EXISTS wallet
(
    id         INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    money      DECIMAL,
    account_id INTEGER UNSIGNED
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS payment
(
    id           INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pay_id       VARCHAR(100),
    create_time  DATETIME,
    total_price  DECIMAL,
    expires      INTEGER          NOT NULL,
    payment_link VARCHAR(300),
    pay_state    VARCHAR(20)
) engine = InnoDB;
