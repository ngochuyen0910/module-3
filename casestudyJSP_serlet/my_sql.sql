drop database if exists casestudyJSP_serlet;

create database casestudyJSP_serlet;

use casestudyJSP_serlet;

create table `position`(
position_id int primary key auto_increment,
position_name varchar(45)
);

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

create table division(
division_id int primary key auto_increment,
division_name varchar(45)
);

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
foreign key(position_id) references `position`(position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id) references division(division_id)
);

create table customer_type(
customer_type_id int primary key,
customer_type_name varchar(45)
);

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(45),
customer_birthday date,
customer_gender int,
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int,
 foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45)
);

create table facility_type(
facility_type_id int primary key,
facility_type_name varchar(45)
);

create table facility(
facility_id int primary key auto_increment,
facility_name varchar(45),
area int,
cost double,
max_people int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
facility_free text,
rent_type_id int,
facility_type_id int,
foreign key(rent_type_id) references rent_type(rent_type_id),
foreign key(facility_type_id) references facility_type(facility_type_id)
);

create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime,
contract_end_date datetime,
deposit double,
employee_id int,
customer_id int,
facility_id int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(facility_id) references facility(facility_id)
);

create table attach_facility(
attach_facility_id int primary key auto_increment,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);

create table contract_detail(
contract_detail_id int primary key auto_increment,
quanity int,
contract_id int,
attach_facility_id int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_facility_id) references attach_facility(attach_facility_id)
);

insert into `position`(position_id,position_name)
values
(1,"Lễ tân"),
(2,"Phục vụ"),
(3,"Chuyên viên"),
(4,"Giám sát"),
(5,"Quản lý"),
(6,"Giám đốc");

insert into education_degree(education_degree_id,education_degree_name)
values
(1,"Trung cấp"),
(2,"Cao đẳng"),
(3,"Đại học"),
(4,"Sau đại học");

insert into division(division_id, division_name)
values
(1,"Sale – Marketing"),
(2,"Hành Chính"),
(3,"Phục vụ"),
(4,"Quản lý");

insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)
values
(1,'Nguyễn Văn An', '1994-01-08','456231786','10000000','0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình', '1997-04-09','654231234','7000000','0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2);

insert into customer_type(customer_type_id, customer_type_name)
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

insert into customer(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id)
values
(1,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1);