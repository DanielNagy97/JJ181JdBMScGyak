CREATE TABLE GYARTO(
    adoszam int PRIMARY KEY,
    nev varchar(30),
    irsz varchar(4),
    varos varchar(40),
    utca varchar(100)
);

CREATE TABLE TERMEK(
    tkod int PRIMARY KEY,
    nev varchar(50),
    ear int CHECK(ear > 0),
    gyarto int REFERENCES GYARTO(nev)
);

CREATE TABLE ALKATRESZ(
    akod int PRIMARY KEY,
    nev varchar(50) NOT NULL
);

CREATE TABLE KOMPONENS(
    termek int REFERENCES TERMEK(nev),
    alkatresz int REFERENCES ALKATRESZ(akod)
);

CREATE TABLE EGYSEGEK(
    aru int REFERENCES TERMEK(tkod),
    db int CHECK(db > 0)
);

