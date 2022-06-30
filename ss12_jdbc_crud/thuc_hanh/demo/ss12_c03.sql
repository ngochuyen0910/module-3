create database ss12_c03;

use ss12_c03;

create table student(
id int primary key auto_increment,
`name` varchar(50),
class_name varchar(10),
gender int,
score double
);

insert into student(`name`,class_name,gender,score) values("Huyen","C03",1,8);
insert into student(`name`,class_name,gender,score) values("Hoa","C03",1,9);
insert into student(`name`,class_name,gender,score) values("Hong","C03",1,7);