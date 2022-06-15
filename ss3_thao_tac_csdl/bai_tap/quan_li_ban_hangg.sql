create database bai_3_quan_ly_ban_hang ;

use bai_3_quan_ly_ban_hang ;

create table customer(
id_customer int primary key ,
name_customer varchar(50) ,
age int 
);

create table order1(
id_order1 int primary key ,
`date` date ,
total_price double ,
id_customer int ,
foreign key (id_customer) references customer(id_customer)
);

create table product(
id_product int primary key ,
name_product varchar(50) ,
price double 
);

create table order_detail(
qty int,
id_order1 int,
id_product int,
primary key(id_order1, id_product),
foreign key(id_order1) references order1(id_order1),
foreign key(id_product) references product(id_product)
);

insert into customer
values
(1,'Minh Quan', 10),
(2,'Ngoc Oanh', 20),
(3,'Hong Ha', 50);

insert into order1(id_order1,`date`,total_price,id_customer)
values
(1,'2006-03-21',null,1),
(2,'2006-03-23',null,2),
(3,'2006-03-16',null,1);

insert into product (id_product, name_product, price)
values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail(qty,id_order1,id_product)
values
(3,1,1),
(7,1,3),
(2,1,4),
(1,2,1),
(8,3,1),
(4,2,5),
(3,2,3);

select order1.id_order1, order1.`date`, product.price
from order1
join order_detail on order1.id_order1 = order_detail.id_order1
join product on product.id_product = order_detail.id_product ;

select customer.name_customer, product.name_product, product.price
from customer
join order1 on customer.id_customer= order1.id_customer
join order_detail on order1.id_order1 = order_detail.id_order1
join product on product.id_product = order_detail.id_product ;

select *, count(order1.id_customer)
from customer
left join order1 on customer.id_customer = order1.id_customer
group by order1.id_order1
having count(order1.id_customer) = 0;

select order1.id_order1, order1.`date`, sum(order_detail.qty * product.price)
from order1
join order_detail on order1.id_order1 = order_detail.id_order1
join product on product.id_product = order_detail.id_product 
group by order1.id_order1;


