-- CREATE DATABASE cinema;
CREATE TABLE account (
                         id SERIAL PRIMARY KEY,
                         username VARCHAR NOT NULL,
                         email VARCHAR NOT NULL UNIQUE,
                         phone VARCHAR NOT NULL UNIQUE
);
INSERT INTO account (username, email, phone) VALUES ('Иванов Иван Иванович', 'ivanov@mail.ru', '01');
INSERT INTO account (username, email, phone) VALUES ('Петров Петр Петрович', 'petrov@mail.ru', '89090000009');

CREATE TABLE ticket (
                        id SERIAL,
                        session_id INT NOT NULL,
                        row INT NOT NULL,
                        cell INT NOT NULL,
                        account_id INT NOT NULL REFERENCES account(id),
                        CONSTRAINT order_details PRIMARY KEY (session_id, row, cell)
);

CREATE TABLE cells (
                        id SERIAL PRIMARY KEY,
                        occupied BOOLEAN NOT NULL,
                        row INT NOT NULL,
                        cell INT NOT NULL
);
INSERT INTO cells (occupied, row, cell) VALUES ('FALSE', 1, 1), ('FALSE', 1, 2), ('FALSE', 1, 3),
                                               ('FALSE', 2, 1), ('FALSE', 2, 2), ('FALSE', 2, 3),
                                               ('FALSE', 3, 1), ('FALSE', 3, 2), ('FALSE', 3, 3);
