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
    vald boolean,
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

insert into bord (id, status) values (1, 'Ledigt');
insert into bord (id, status) values (2, 'Ledigt');
insert into bord (id, status) values (3, 'Ledigt');
insert into bord (id, status) values (4, 'Ledigt');
insert into bord (id, status) values (5, 'Ledigt');
insert into bord (id, status) values (6, 'Ledigt');
insert into bord (id, status) values (7, 'Ledigt');
insert into bord (id, status) values (8, 'Ledigt');


insert into alacarte (titel, beskrivning, typ_id, vald, pris) values ('Toast Skagen', 'Toast med skagenröra', 1, false, 50);
insert into alacarte (titel, beskrivning, typ_id, vald, pris) values ('Toast', 'Toast med ost och skinka', 1, false, 50);
insert into alacarte (titel, beskrivning, typ_id, vald, pris) values ('Köttbullar', 'Köttbullar med potatismos och lingon', 2, false, 50);
insert into alacarte (titel, beskrivning, typ_id, vald, pris) values ('Pannbiff', 'Pannbiff med potatismos och lingon', 2, false, 50);

insert into bestallning (datum, tid, kommentar, bord_id) values ('2023-11-01', '16:11:00', 'Alla i sällskapet vill ha varmrätten vid olika tillfällen', 1);
insert into bestallning (datum, tid, kommentar, bord_id) values ('2023-11-01', '16:37:00', 'Kungen på besök', 2);

insert into ratt_instans (tag_id, ratt_preferenser, bestallning_id, alacarte_id) values (1, 'Ingen lök på toast skagen', 1, 1);
insert into ratt_instans (tag_id, bestallning_id, alacarte_id) values (1, 1, 2);
insert into ratt_instans (tag_id, ratt_preferenser, bestallning_id, alacarte_id) values (1, 'Vill ha köttbullar till förrätt', 1, 3);

insert into ratt_instans (tag_id, bestallning_id, alacarte_id) values (1, 2, 1);
insert into ratt_instans (tag_id, bestallning_id, alacarte_id) values (1, 2, 2);
insert into ratt_instans (tag_id, bestallning_id, alacarte_id) values (2, 2, 3);





insert into lunch (titel, beskrivning) values ('Köttbullar', 'Köttbullar med potatismos och lingon');
insert into lunch (titel, beskrivning) values ('Pannbiff', 'Pannbiff med potatismos och lingon');
insert into lunch (titel, beskrivning) values ('Pasta', 'Pasta med köttfärssås');
insert into lunch (titel, beskrivning) values ('Kyckling', 'Kyckling med ris och currysås');
insert into lunch (titel, beskrivning) values ('Sallad', 'Sallad med kyckling');

insert into lunch_vecka (dag_id, lunch_id)values (1, 1);
insert into lunch_vecka (dag_id, lunch_id)values (1, 2);
insert into lunch_vecka (dag_id, lunch_id)values (2, 2);
insert into lunch_vecka (dag_id, lunch_id)values (3, 3);
insert into lunch_vecka (dag_id, lunch_id)values (4, 4);
insert into lunch_vecka (dag_id, lunch_id)values (5, 5);





