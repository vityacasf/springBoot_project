create table "user"
(
    user_id  serial primary key,
    login    varchar not null unique,
    password varchar not null
);
