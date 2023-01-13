create table matches
(
    id     serial,
    team_a_id int not null,
    team_b_id int not null,
    date_time timestamp not null,
    stadium varchar not null,
    primary key (id),
    FOREIGN KEY (team_a_id) REFERENCES team (id),
    FOREIGN KEY (team_b_id) REFERENCES team (id)
);

insert into matches(team_a_id, team_b_id, date_time, stadium)
values(1,2,'2022-08-12T08:30:00','gymnase couvert'),
        (2,1,'2022-08-12T14:30:00','gymnase');