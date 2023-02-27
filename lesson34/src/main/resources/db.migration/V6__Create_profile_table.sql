create table "profile"
(
    profile_id   serial primary key,
    user_id integer,
    image_id integer,
    constraint fk_user_id
        foreign key(user_id)
            references "user"(user_id) on update cascade on delete cascade,
    constraint fk_image_id
        foreign key(image_id)
            references image(image_id) on update cascade on delete cascade
);
