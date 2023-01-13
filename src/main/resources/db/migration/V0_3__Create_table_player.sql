create table player
(
    id     serial,
    name varchar not null unique,
    number int not null,
    post varchar not null,
    team_id int not null,
    primary key (id),
    FOREIGN KEY (team_id) REFERENCES team(id)
);

insert into player (name,number,post,team_id)
values('George',1,'player',1),
        ('Michael',2,'player',2),
        ('Dany',4,'player',1),
        ('Max',7,'player',1),
        ('Edy',3,'goal',1),
        ('Lorenzo',5,'player',3),
        ('Mathieu',10,'goal',2);