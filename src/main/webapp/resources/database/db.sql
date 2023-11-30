drop database if exists antonsskafferi;
create database antonsskafferi;
use antonsskafferi;

create table lunch(
    id int unsigned auto_increment not null,
    titel varchar(255),
    beskrivning text,
    primary key (id)
);

CREATE TABLE dag (
    id int unsigned auto_increment not null,
    namn varchar(255),
    primary key (id)
);

CREATE TABLE lunch_vecka (
    dag_id int references dag(id),
    lunch_id int references lunch(id),
    primary key (lunch_id, dag_id)
);

create table typ(
    id int unsigned auto_increment not null,
    namn varchar(255) not null,
    primary key (id)
);

create table alacarte(
    id int unsigned auto_increment not null,
    titel varchar(255) not null,
    beskrivning text,
    typ_id int references typ(id),
    vald boolean,
    pris int,
    primary key (id)
);

create table beställning(
    id int unsigned auto_increment not null,
    datum date not null,
    tid time not null,
    kommentar text,
    bord_id int references bord(id),
    primary key (id)
);

create table rätt_instans(
    id int unsigned auto_increment not null,
    tag_id int references typ(id),
    rätt_preferenser text,
    beställning_id int references beställning(id),
    alacarte_id int references alacarte(id),
    primary key (id, beställning_id, alacarte_id)

);

create table bord(
    id int not null,
    status varchar(255) not null,
    primary key (id)
);

insert into dag (namn) values ('Måndag');
insert into dag (namn) values ('Tisdag');
insert into dag (namn) values ('Onsdag');
insert into dag (namn) values ('Torsdag');
insert into dag (namn) values ('Fredag');

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

insert into beställning (datum, tid, kommentar, bord_id) values ('2023-11-01', '16:11:00', 'Alla i sällskapet vill ha varmrätten vid olika tillfällen', 1);
insert into beställning (datum, tid, kommentar, bord_id) values ('2023-11-01', '16:37:00', 'Kungen på besök', 2);

insert into rätt_instans (tag_id, rätt_preferenser, beställning_id, alacarte_id) values (1, 'Ingen lök på toast skagen', 1, 1);
insert into rätt_instans (tag_id, beställning_id, alacarte_id) values (1, 1, 2);
insert into rätt_instans (tag_id, rätt_preferenser, beställning_id, alacarte_id) values (1, 'Vill ha köttbullar till förrätt', 1, 3);

insert into rätt_instans (tag_id, beställning_id, alacarte_id) values (1, 2, 1);
insert into rätt_instans (tag_id, beställning_id, alacarte_id) values (1, 2, 2);
insert into rätt_instans (tag_id, beställning_id, alacarte_id) values (2, 2, 3);





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





