drop database if exists antonsskafferi;
create database antonsskafferi;
use antonsskafferi;

set CHARACTER SET utf8;
create table lunch(
                      id int auto_increment not null,
                      titel varchar(255),
                      beskrivning text,
                      primary key (id)
);

CREATE TABLE dag (
                     id int not null,
                     namn varchar(255),
                     primary key (id)
);

CREATE TABLE lunch_vecka (
                             dag_id int references dag(id),
                             lunch_id int references lunch(id),
                             primary key (lunch_id, dag_id)
);

create table typ(
                    id int auto_increment not null,
                    namn varchar(255) not null,
                    primary key (id)
);

create table alacarte(
                         id int auto_increment not null,
                         titel varchar(255) not null,
                         beskrivning text,
                         typ_id int references typ(id),
                         vald int,
                         pris int,
                         primary key (id)
);
create table bord(
                     id int not null,
                     status varchar(255) not null,
                     primary key (id)
);
create table bestallning(
                            id int auto_increment not null,
                            datum date not null,
                            tid time not null,
                            kommentar text,
                            bord_id int references bord(id),
                            primary key (id)
);

create table ratt_instans(
                             id int auto_increment not null,
                             tag_id int references typ(id),
                             ratt_preferenser text,
                             bestallning_id int references bestallning(id),
                             alacarte_id int references alacarte(id),
                             primary key (id, bestallning_id, alacarte_id)

);



insert into dag (id, namn) values (1, 'Måndag');
insert into dag (id, namn) values (2, 'Tisdag');
insert into dag (id, namn) values (3, 'Onsdag');
insert into dag (id, namn) values (4, 'Torsdag');
insert into dag (id, namn) values (5, 'Fredag');

insert into typ (namn) values ('Förrätt');
insert into typ (namn) values ('Varmrätt');
insert into typ (namn) values ('Efterrätt');
insert into typ (namn) values ('Dryck');






