create table message
(
    message_id   serial primary key,
    sender_id    integer,
    recipient_id integer,
    text text
);
