show tables;

CREATE TABLE user_table
(
    user_id    varchar(128) NOT NULL,
    user_pw    varchar(255) NOT NULL,
    user_name  varchar(255) NOT NULL,
    user_phone varchar(255),
    user_point int DEFAULT 0,
    PRIMARY KEY (user_id)
);

CREATE TABLE company_table
(
    company_name    varchar(255) NOT NULL,
    company_phone     varchar(255)     NOT NULL,
    company_url   varchar(255) NOT NULL,
    PRIMARY KEY (company_name)
);

CREATE TABLE product_table
(
    productname_companyname varchar(255) not null,
    product_name            varchar(255) NOT NULL,
    product_price           LONG         NOT NULL,
    supply_point            int          NOT NULL,
    company_name            varchar(255) NOT NULL,
    PRIMARY KEY (productName_companyname),
    FOREIGN KEY (company_name) REFERENCES company_table (company_name)
);

show tables;

CREATE TABLE order_table
(
    order_id                varChar(255) not null,
    order_date              varChar(255) not null,
    order_quantity          int          not null,
    used_point              int          not null,
    used_money              int          not null,
    total_payment           long         not null,
    user_id                 varchar(128) NOT NULL,
    productname_companyname varchar(255) not null,
    PRIMARY KEY (order_id),
    FOREIGN KEY (user_id) REFERENCES user_table (user_id),
    FOREIGN KEY (productname_companyname) REFERENCES product_table (productname_companyname)
);
