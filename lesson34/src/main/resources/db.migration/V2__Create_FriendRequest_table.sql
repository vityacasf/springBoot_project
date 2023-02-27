create table friend_request
(
    request_id   serial primary key,
    sender_id    integer,
    recipient_id integer
);
