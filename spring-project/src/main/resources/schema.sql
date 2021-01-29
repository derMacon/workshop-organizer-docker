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

create table if not exists course
(
    course_id serial primary key,
    host_id integer not null,
    foreign key (host_id) references person(person_id),
    course_name varchar(100) not null,
    course_summary varchar(5000),
    course_description varchar(5000),
    max_participant_count integer
);

create table if not exists announcement
(
    announcement_id serial primary key,
    title varchar(100) not null,
    content varchar(5000),
    publishing_date date not null,
    course_id integer not null,
    foreign key (course_id) references course (course_id)
);

create table if not exists course_person
(
    course_id integer not null,
    person_id integer not null,
    foreign key (course_id) references course(course_id),
    foreign key (person_id) references person(person_id),
    CONSTRAINT bill_product_pkey PRIMARY KEY (course_id, person_id)
);

create table if not exists meeting(
    meeting_id serial primary key,
    meeting_date date not null,
    address varchar(100) not null,
    course_id integer not null,
    foreign key (course_id) references course(course_id)
)
