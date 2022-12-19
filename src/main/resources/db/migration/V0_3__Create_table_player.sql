create table player
(
    id     serial,
    name varchar not null unique,
    number int not null,
    primary key (id)
);