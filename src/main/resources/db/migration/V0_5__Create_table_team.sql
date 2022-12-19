create table team
(
    id     serial,
    name varchar not null unique,
    primary key (id)
);

create table team_player
(
    id_team int,
    id_player int,
    FOREIGN KEY (id_team) REFERENCES team (id),
    FOREIGN KEY (id_player) REFERENCES player (id)
);

create table team_sponsor
(
    id_team int,
    id_sponsor int,
    FOREIGN KEY (id_team) REFERENCES team (id),
    FOREIGN KEY (id_sponsor) REFERENCES sponsor (id)
)