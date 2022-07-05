create database quanlysinhvien;

use quanlysinhvien;

create table class(
idclass int not null auto_increment primary key,
`name` varchar(60) not null,
startdate datetime not null,
`status` bit 
);

create table student(
idstudent int not null auto_increment primary key,
`name` varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
idclass int not null,
foreign key(idclass) references class(idclass)
);

create table `subject`(
idsub int not null auto_increment primary key,
`name` varchar(30) not null,
credit tinyint not null default 1 check(credit>=1),
status bit default 1
);

create table mark(
idmark int not null auto_increment primary key,
idsub int not null,
idstudent int not null,
mark float default 0 check(mark between 0 and 100),
examtimes tinyint default 1,
unique(idsub,idstudent),
foreign key(idsub) references `subject`(idsub),
foreign key(idstudent) references student(idstudent)
);
