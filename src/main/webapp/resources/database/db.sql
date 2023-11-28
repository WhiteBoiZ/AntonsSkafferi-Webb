drop database if exists antonsskafferi;
create database antonsskafferi;
use antonsskafferi;

create table lunch(
    id int unsigned auto_increment not null,
    titel varchar(255) not null,
    beskrivning TEXT,
    primary key (id)
);

CREATE TABLE dag (
    id SERIAL PRIMARY KEY,
    namn VARCHAR(50) NOT NULL
);

CREATE TABLE lunch_vecka (
    day_id INT REFERENCES dag(id),
    lunch_id INT REFERENCES lunch(id),
    PRIMARY KEY (lunch_id, day_id)
);

create table alacarte(
    id int unsigned auto_increment not null,
    titel varchar(255) not null,
    beskrivning varchar(255) not null,
    typ varchar(255) not null,
    vald boolean not null,
    pris int unsigned not null,
    primary key (id)
);

create table beställning(
    id int unsigned auto_increment not null,
    datum date not null,
    tid time not null,
    namn varchar(255) not null,
    telefon varchar(255) not null,
    email varchar(255) not null,
    primary key (id)
);


create table bord(
    id int unsigned auto_increment not null,
    status varchar(255) not null,
    primary key (id)
);

insert into dag (namn) values ('Måndag');
insert into dag (namn) values ('Tisdag');
insert into dag (namn) values ('Onsdag');
insert into dag (namn) values ('Torsdag');
insert into dag (namn) values ('Fredag');

insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Köttbullar', 'Köttbullar med potatismos och lingon', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Pannbiff', 'Pannbiff med potatismos och lingon', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Pasta', 'Pasta med köttfärssås', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Kyckling', 'Kyckling med ris och currysås', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Sallad', 'Sallad med kyckling', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Soppa', 'Soppa med bröd', 'varmrätt', false, 95);
insert into alacarte (titel, beskrivning, typ, vald, pris) values ('Köttbullar', 'Köttbullar med potatismos och lingon', 'varmrätt', false, 95);

insert into lunch (titel, beskrivning) values ('Köttbullar', 'Köttbullar med potatismos och lingon');
insert into lunch (titel, beskrivning) values ('Pannbiff', 'Pannbiff med potatismos och lingon');
insert into lunch (titel, beskrivning) values ('Pasta', 'Pasta med köttfärssås');
insert into lunch (titel, beskrivning) values ('Kyckling', 'Kyckling med ris och currysås');
insert into lunch (titel, beskrivning) values ('Sallad', 'Sallad med kyckling');

insert into lunch_vecka (day_id, lunch_id) values (1, 1);
insert into lunch_vecka (day_id, lunch_id) values (1, 2);
insert into lunch_vecka (day_id, lunch_id) values (2, 2);
insert into lunch_vecka (day_id, lunch_id) values (3, 3);
insert into lunch_vecka (day_id, lunch_id) values (4, 4);
insert into lunch_vecka (day_id, lunch_id) values (5, 5);





