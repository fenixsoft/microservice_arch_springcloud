DROP TABLE specification IF EXISTS;
DROP TABLE advertisement IF EXISTS;
DROP TABLE stockpile IF EXISTS;
DROP TABLE product IF EXISTS;

CREATE TABLE product
(
    id          INTEGER IDENTITY PRIMARY KEY,
    title       VARCHAR(50),
    price       DECIMAL,
    rate        FLOAT,
    description VARCHAR(8000),
    cover       VARCHAR(100),
    detail      VARCHAR(100)
);
CREATE INDEX product_title ON product (title);

CREATE TABLE stockpile
(
    id         INTEGER IDENTITY PRIMARY KEY,
    amount     INTEGER,
    frozen     INTEGER,
    product_id INTEGER
);
ALTER TABLE stockpile
    ADD CONSTRAINT fk_stockpile_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE;

CREATE TABLE specification
(
    id         INTEGER IDENTITY PRIMARY KEY,
    item       VARCHAR(50),
    value      VARCHAR(100),
    product_id INTEGER
);
ALTER TABLE specification
    ADD CONSTRAINT fk_specification_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE;

CREATE TABLE advertisement
(
    id         INTEGER IDENTITY PRIMARY KEY,
    image      VARCHAR(100),
    product_id INTEGER
);
ALTER TABLE advertisement
    ADD CONSTRAINT fk_advertisement_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE;
