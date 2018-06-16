-- to mi nie dziala z jakiegos powodu, wiec tworzenie recznie w main

create table pies(id BIGINT PRIMARY KEY AUTO_INCREMENT,
                  imie VARCHAR(30),
                  wiek INTEGER,
                  obroza_id INTEGER,

  PRIMARY KEY (id)
);


insert into pies(imie, wiek, obroza_id) VALUES ('Fafik',12,1);
insert into pies(imie, wiek, obroza_id) VALUES ('Maksiu',15,2);
insert into pies(imie, wiek, obroza_id) VALUES ('Puszek',5,3);
insert into pies(imie, wiek, obroza_id) VALUES ('DzikiPies',15,4);

