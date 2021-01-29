create table if not exists app_user
(
    user_id  serial primary key,
    username varchar(500) unique not null,
    password varchar(5000)       not null,
    role     varchar(5000)       not null
);

create table if not exists persistent_logins
(
    username  varchar(500) not null,
    series    serial primary key,
    token     varchar(64)  not null,
    last_used timestamp    not null
);

create table if not exists person
(
    person_id serial primary key,
    firstname varchar(500) not null,
    surname   varchar(500) not null,
    email     varchar(500) not null,
    user_id   integer      not null,
    foreign key (user_id) references app_user (user_id)
);

create table test_table
(
    id        serial primary key,
    firstname varchar(500) not null
);
