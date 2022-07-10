drop database if exists benh_vien;

create database benh_vien;

use benh_vien;
create table benh_an(
ma_benh_an int primary key auto_increment,
ten_benh_an varchar(50)
);

create table benh_nhan(
stt int primary key auto_increment,
ma_benh_an int,
ma_benh_nhan varchar(50),
ten_benh_nhan varchar(50),
ngay_nhap_vien date,
ngay_ra_vien date,
ly_do_nhap_vien varchar(225),
foreign key(ma_benh_an) references benh_an(ma_benh_an)
);

insert into benh_an(ma_benh_an,ten_benh_an)
values
(1,'BA-001'),
(2,'BA-112'),
(3,'BA-223'),
(4,'BA-444');

insert into benh_nhan(stt,ma_benh_an,ma_benh_nhan,ten_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien)
values
(1,1,'BN-001','Hoa','2012-12-12','2012-12-13','Bị ốm'),
(2,2,'BN-021','Hồng','2015-01-01','2015-01-13','Bị ốm'),
(3,3,'BN-031','Đẹp','2017-12-12','2017-12-13','Bị ốm');