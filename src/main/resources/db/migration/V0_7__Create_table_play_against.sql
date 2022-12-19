create table play_against
(
    id     serial,
    team1_id int not null,
    team2_id int not null,
    date_time timestamp not null,
    stadium varchar not null,
    primary key (id),
    FOREIGN KEY (team1_id) REFERENCES team (id),
    FOREIGN KEY (team2_id) REFERENCES team (id)
);