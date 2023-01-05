CREATE TABLE users
(
    id         BIGSERIAL NOT NULL UNIQUE,
    name       VARCHAR   NOT NULL UNIQUE,
    role       VARCHAR   NOT NULL,
    password   VARCHAR   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO users (name, role, password)
VALUES ('Olga', 'EMPLOYEE', '123');
INSERT INTO users (name, role, password)
VALUES ('Viktor', 'ADMIN', '123');
INSERT INTO users (name, role, password)
VALUES ('Vlad', 'MANAGER', '123');
