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
(1,"L??? t??n"),
(2,"Ph???c v???"),
(3,"Chuy??n vi??n"),
(4,"Gi??m s??t"),
(5,"Qu???n l??"),
(6,"Gi??m ?????c");

insert into education_degree(education_degree_id,education_degree_name)
values
(1,"Trung c???p"),
(2,"Cao ?????ng"),
(3,"?????i h???c"),
(4,"Sau ?????i h???c");

insert into division(division_id, division_name)
values
(1,"Sale ??? Marketing"),
(2,"H??nh Ch??nh"),
(3,"Ph???c v???"),
(4,"Qu???n l??");

insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id)
values
(1,'Nguy???n V??n An', '1994-01-08','456231786','10000000','0901234121','annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
(2,'L?? V??n B??nh', '1997-04-09','654231234','7000000','0934212314','binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,2),
(3,'H??? Th??? Y???n','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',1,3,2),
(4,'V?? C??ng To???n','1980-04-04','123231365','17000000','0374443232','toan0404@gmail.com','77 Ho??ng Di???u, Qu???ng Tr???',1,4,4),
(5,'Nguy???n B???nh Ph??t','1999-12-09','454363232','6000000','0902341231','phatphat@gmail.com','43 Y??n B??i, ???? N???ng',2,1,1),
(6,'Kh??c Nguy???n An Nghi','2000-11-08','964542311','7000000','0978653213','annghi20@gmail.com','294 Nguy???n T???t Th??nh, ???? N???ng',2,3,3),
(7,'Nguy???n H???u H??','1993-01-01','534323231','8000000','0941234553','nhh0101@gmail.com','4 Nguy???n Ch?? Thanh, Hu???',2,3,2),
(8,'Nguy???n H?? ????ng','1989-09-03','234414123','9000000','0642123111','donghanguyen@gmail.com','111 H??ng V????ng, H?? N???i',2,4,4),
(9,'T??ng Hoang','1982-09-03','256781231','6000000','0245144444','hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',2,4,4),
(10,'Nguy???n C??ng ?????o','1994-01-08','755434343','8000000','0988767111','nguyencongdao12@gmail.com','6 Ho?? Kh??nh, ?????ng Nai',2,3,2);

insert into customer_type(customer_type_id, customer_type_name)
values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

insert into customer(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id)
values
(1,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng',5),
(2,'Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???',3),
(3,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh',1),
(4,'D????ng V??n Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng',1),
(5,'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai',4),
(6,'T??n N??? M???c Ch??u','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng',4),
(7,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh',1),
(8,'Nguy???n Th??? H??o','1999-04-08',1,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum',3),
(9,'Tr???n ?????i Danh','1994-07-01',1,'344343432','0987654321','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i',1),
(10,'Nguy???n T??m ?????c','1989-07-01',1,'432341235','0643343433','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng',2);
insert into rent_type(rent_type_id, rent_type_name)
values
(1,"N??m"),
(2,"Th??ng"),
(3,"Ng??y"),
(4,"Gi???");

insert into facility_type(facility_type_id,facility_type_name)
values
(1,"Villa"),
(2,"House"),
(3,"Room");

insert into facility(facility_id,facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id)
values
(1,'Villa Beach Front','25000','10000000',10,'vip','C?? h??? b??i',500,4,2,1,1),
(2,'House Princess 01','14000','5000000',7,'vip','C?? th??m b???p n?????ng',null,3,2,2,2),
(3,'Room Twin 01','5000','1000000',2,'vip','C?? tivi',null,null,4,3,3);
insert into facility(facility_id,facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id)
values
(4,'Villa No Beach Front','22000','9000000',8,'normal','C?? h??? b??i',300,3,3,1,1),
(5,'House Princess 02','10000','4000000',5,'normal','C?? th??m b???p n?????ng',null,2,3,2,2),
(6,'Room Twin 02','3000','900000',2,'normal','C?? tivi',null,null,4,3,3);

insert into contract(contract_id,contract_start_date,contract_end_date,deposit,employee_id,customer_id,facility_id)
values
(1,'2020-12-08','2020-12-08','0',3,1,3),
(2,'2020-07-14','2020-07-21','200000',7,3,1),
(3,'2021-03-15','2021-03-17','50000',3,4,2),
(4,'2021-01-14','2021-01-18','100000',7,5,2),
(5,'2021-07-14','2021-07-15','0',7,2,1);

insert into attach_facility(attach_facility_id, attach_facility_name, attach_facility_cost, attach_facility_unit, attach_facility_status)
values
(1,'karaoke','10000','gi???','ti???n nghi, hi???n t???i'),
(2,'Thu?? xe m??y','10000','chi???c','h???ng 1 xe'),
(3,'Thu?? xe ?????p','20000','chi???c','t???t'),
(4,'Buffet bu???i s??ng','15000','su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(5,'Buffet bu???i tr??a','90000','su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(6,'Buffet bu???i t???i','16000','su???t','?????y ????? ????? ??n, tr??ng mi???ng');

insert into contract_detail(contract_detail_id,quanity, contract_id, attach_facility_id)
values
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1);





