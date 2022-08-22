create database kishore;
use kishore;
create table Accountinfo (
	username varchar(50) ,
    Email varchar(50) primary key,
    Passwd varchar(15),
    phonenum varchar(10)
);
create table sent(
	Sentby varchar(30),
    Receiveby varchar(30),
    message varchar(1000)
);
create table receive(
	Receiveby varchar(30),
    Sentby varchar(30),
    message varchar(1000)
);
select * from Accountinfo;
select * from sent;
select * from receive;
drop table receive;
drop table sent;
delete from receive;
delete from sent;
delete from Accountinfo;
select Email from Accountinfo where Email='arungv@gmail.com';