create database quan_ly_sinh_vien;

use quan_ly_sinh_vien;

create table class(
id_class int primary key auto_increment,
name_class varchar(60) not null,
start_date datetime not null,
`status` bit
);

create table student(
id_student int primary key auto_increment,
name_student varchar(30),
address varchar(50),
phone varchar(20),
`status` bit,
id_class int,
foreign key(id_class) references class(id_class)
);

create table `subject`(
id_sub int primary key auto_increment,
name_subject varchar(30) not null,
credit tinyint not null default 1 check (credit>=1),
`status` bit default 1
);

create table mark(
id_mark int primary key auto_increment,
mark float default 0 check(mark between 0 and 100),
exam_times tinyint default 1,
id_sub int,
id_student int,
unique(id_sub, id_student),
foreign key (id_sub) references `subject`(id_sub),
foreign key (id_student) references student(id_student)
);

insert into class
values
(1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);

insert into student(name_student,address,phone,`status`,id_class)
values
('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai phong','0123123123', 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);

insert into `subject`
values
(1, 'CF', 5, 1),
(2, 'C', 6, 1),
(3, 'HDJ', 5, 1),
(4, 'RDBMS', 10, 1);

insert into mark(id_sub,id_student,mark,exam_times)
values
(1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 12, 1);

select student.id_student, student.name_student, class.name_class
from student student join class class on student.id_class = class.id_class;

select student.id_student, student.name_student, class.name_class
from student student join class on student.id_class = class.id_class
where class.name_class= 'A1';

select student.id_student, student.name_student, `subject`.name_subject, mark.mark
from student student join mark mark on student.id_student= mark.id_student join `subject` `subject` on mark.id_sub = `subject`.id_sub;

select student.id_student, student.name_student, `subject`.name_subject, mark.mark
from student student join mark mark on student.id_student= mark.id_student join `subject` `subject` on mark.id_sub = `subject`.id_sub
where `subject`.name_subject= 'CF';

select * from student
where name_student like 'h%';

select * from class
where month(start_date)=12;

select * from `subject`
where credit between 3 and 5;

update student
set id_class = 2
where name_student = 'Hung';

select name_student, name_subject, mark
from student
join mark on student.id_student= mark.id_student
join `subject` on mark.id_sub= `subject`.id_sub
order by mark.mark desc, student.name_student asc;




