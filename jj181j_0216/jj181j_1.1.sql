CREATE DATABASE DBMSC;

USE DBMSC;

CREATE TABLE GYARTO(
    adoszam int PRIMARY KEY,
    nev varchar(30),
    telephely varchar(150)
);

CREATE TABLE TERMEK(
    tkod int PRIMARY KEY,
    nev varchar(50),
    ear int CHECK(ear > 0),
    gyarto int REFERENCES GYARTO(nev)
);

