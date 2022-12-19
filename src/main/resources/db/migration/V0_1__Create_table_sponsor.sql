create table sponsor
(
    id     serial,
    name varchar not null unique,
    primary key (id)
);