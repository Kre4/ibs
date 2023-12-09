drop table books_copies;

create table books_copies
(
    id        bigserial primary key,
    system_id text,
    book_id   bigint references book (id) not null,
    status_id int references status (id)  not null
);