create table score(
    id serial,
    match_id int not null,
    player_id int not null,
    times int,
    isOS boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (match_id) REFERENCES matches(id),
    FOREIGN KEy (player_id) REFERENCES player(id)
);

insert into score(match_id, player_id, times, isOS)
values(1,1,15,true),
        (1,4,40,false),
        (1,7,50,true),
        (1,6,40,true);