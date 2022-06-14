create database quan_ly_ban_hang ;

use quan_ly_ban_hang ;

create table customer(
id_customer int primary key not null,
name varchar(50) not null,
age int not null
);

create table order1(
id_order1 int primary key not null,
`date` date not null,
total_price double not null,
id_customer int not null,
foreign key (id_customer) references customer(id_customer)
);

create table product(
id_product int primary key not null,
`name` varchar(50) not null,
price double not null
);

create table order_detail(
qty int,
id_order1 int,
id_product int,
primary key(id_order1, id_product),
foreign key(id_order1) references order1(id_order1),
foreign key(id_product) references product(id_product)
);
