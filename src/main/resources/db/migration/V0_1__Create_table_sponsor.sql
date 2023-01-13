create table sponsor
(
    id     serial,
    name varchar not null unique,
    primary key (id)
);

insert into sponsor (name)
values('coca'),
        ('fresh'),
        ('norton');