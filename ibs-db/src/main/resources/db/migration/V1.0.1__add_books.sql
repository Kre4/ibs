create table genre
(
    id          serial primary key,
    name        text not null,
    system_name text not null unique
);

create table status
(
    id          serial primary key,
    name        text not null,
    system_name text not null unique
);


create table author
(
    id serial primary key,
    name varchar(255) not null,
    birth_date date,
    death_date date
);

create table book
(
    id bigserial primary key,
    name varchar(255) not null,
    year int,
    description varchar(255),
    publisher varchar(255)
);

create table book_genre
(
    id bigserial primary key,
    book_id bigint references book (id) not null,
    genre_id int references genre (id) not null
);

create table book_author
(
    id bigserial primary key,
    book_id bigint references book (id) not null,
    author_id int references author (id) not null
);

create table books_copies
(
    id bigint primary key,
    book_id bigint references book (id) not null,
    status_id int references status (id) not null
);