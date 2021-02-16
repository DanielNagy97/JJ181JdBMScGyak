CREATE TABLE TANFOLYAM(
    tkod int PRIMARY KEY,
    ar int,
    tipus varchar(50),
    megnevezes varchar(100)
);


CREATE TABLE RESZTVEVO(
    tajszam int PRIMARY KEY,
    lakcim varchar(300),
    nev varchar(50)
);

CREATE TABLE TR(
    tkod int REFERENCES TANFOLYAM(tkod),
    tajszam int REFERENCES RESZTVEVO(tajszam),
    befizetes int
);

