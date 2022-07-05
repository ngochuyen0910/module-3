CREATE database quanlydiemthi;

USE quanlydiemthi;

CREATE TABLE hocsinh(
idstudent varchar(20) primary key,
`name` varchar(50),
birthday date,
class varchar(20),
gender varchar(20)
);

CREATE TABLE monhoc(
idsubject varchar(20) primary key,
`name` varchar(50)
);

CREATE TABLE bangdiem(
idstudent varchar(20),
idsubject varchar(20),
`point` int,
testDay datetime,
primary key(idstudent, idsubject),
foreign key(idstudent) references hocsinh(idstudent),
foreign key(idsubject) references monhoc(idsubject)
);

CREATE TABLE giaovien(
idteacher varchar(20) primary key,
name varchar(20),
phonenumber varchar(10)
);

ALTER TABLE monhoc add idteacher varchar(20);

ALTER TABLE monhoc add constraint  fk_idteacher foreign key(idteacher) references giaovien(idteacher);
