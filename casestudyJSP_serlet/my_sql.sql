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
contract_start_date date,
contract_end_date date,
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
attach_facility_name varchar(45),
attach_facility_cost double,
attach_facility_unit  varchar(45),
attach_facility_status varchar(45)
);

create table contract_detail(
contract_detail_id int primary key auto_increment,
quanity int,
contract_id int,
attach_facility_id int,
foreign key(contract_id) references contract(contract_id),
foreign key(attach_facility_id) references attach_facility(attach_facility_id)
);

select contract.contract_id,facility.facility_id,customer.customer_id, contract.contract_start_date,contract.contract_end_date,contract.deposit, attach_facility.attach_facility_id,
attach_facility.attach_facility_name,attach_facility.attach_facility_cost,attach_facility.attach_facility_unit,attach_facility.attach_facility_status
-- sum(coalesce(facilily.cost,0) + coalesce((contract_detail.quanity * attach_facility.attach_service_cost),0)) as total_money
 from contract
 join facility on contract.facility_id=facility.facility_id
 join customer on contract.customer_id = customer.customer_id
 join contract_detail on contract.contract_id= contract_detail.contract_id
 join attach_facility on contract_detail.attach_facility_id = attach_facility.attach_facility_id;

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
(3,'Hồ Thị Yến','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04','123231365','17000000','0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232','6000000','0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311','7000000','0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,3,3),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231','8000000','0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03','234414123','9000000','0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03','256781231','6000000','0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08','755434343','8000000','0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);

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
(3,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
(7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
(8,'Nguyễn Thị Hào','1999-04-08',1,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
(9,'Trần Đại Danh','1994-07-01',1,'344343432','0987654321','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
(10,'Nguyễn Tâm Đắc','1989-07-01',1,'432341235','0643343433','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
insert into rent_type(rent_type_id, rent_type_name)
values
(1,"Năm"),
(2,"Tháng"),
(3,"Ngày"),
(4,"Giờ");

insert into facility_type(facility_type_id,facility_type_name)
values
(1,"Villa"),
(2,"House"),
(3,"Room");

insert into facility(facility_id,facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id)
values
(1,'Villa Beach Front','25000','10000000',10,'vip','Có hồ bơi',500,4,2,1,1),
(2,'House Princess 01','14000','5000000',7,'vip','Có thêm bếp nướng',null,3,2,2,2),
(3,'Room Twin 01','5000','1000000',2,'vip','Có tivi',null,null,4,3,3);
insert into facility(facility_id,facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id)
values
(4,'Villa No Beach Front','22000','9000000',8,'normal','Có hồ bơi',300,3,3,1,1),
(5,'House Princess 02','10000','4000000',5,'normal','Có thêm bếp nướng',null,2,3,2,2),
(6,'Room Twin 02','3000','900000',2,'normal','Có tivi',null,null,4,3,3);

insert into contract(contract_id,contract_start_date,contract_end_date,deposit,employee_id,customer_id,facility_id)
values
(1,'2020-12-08','2020-12-08','0',3,1,3),
(2,'2020-07-14','2020-07-21','200000',7,3,1),
(3,'2021-03-15','2021-03-17','50000',3,4,2),
(4,'2021-01-14','2021-01-18','100000',7,5,2),
(5,'2021-07-14','2021-07-15','0',7,2,1);

insert into attach_facility(attach_facility_id, attach_facility_name, attach_facility_cost, attach_facility_unit, attach_facility_status)
values
(1,'karaoke','10000','giờ','tiện nghi, hiện tại'),
(2,'Thuê xe máy','10000','chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp','20000','chiếc','tốt'),
(4,'Buffet buổi sáng','15000','suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa','90000','suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối','16000','suất','đầy đủ đồ ăn, tráng miệng');

insert into contract_detail(contract_detail_id,quanity, contract_id, attach_facility_id)
values
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1);





