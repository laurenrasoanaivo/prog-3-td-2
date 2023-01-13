create table team
(
    id     serial,
    name varchar not null unique,
    primary key (id)
);

create table team_sponsor
(
    id_team int,
    id_sponsor int,
    FOREIGN KEY (id_team) REFERENCES team (id),
    FOREIGN KEY (id_sponsor) REFERENCES sponsor (id)
);

insert into team (name)
values('PSG'),
        ('Real'),
        ('Warrior');

insert into team_sponsor
values(1,1),
        (1,2),
        (2,1),
        (1,3);