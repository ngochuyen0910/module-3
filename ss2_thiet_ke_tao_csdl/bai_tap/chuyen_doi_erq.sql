create database chuyen_doi_erq;

use chuyen_doi_erq;

create table phieu_xuat(
so_px int primary key not null,
ngay_xuat date not null
);

create table vat_tu(
ma_vt int primary key not null,
ten_vt varchar(40) not null
);

create table phieu_nhap(
so_pn int primary key not null,
ngay_nhap date not null
);

create table nha_cc(
ma_ncc int primary key not null,
ten_ncc varchar(20),
dia_chi varchar(50)
);

create table sdt_nha_cc(
ma_ncc int not null,
sdt varchar(10) not null,
foreign key(ma_ncc) references nha_cc (ma_ncc)
);

create table don_dh(
so_dh int primary key not null,
ngay_dh date not null,
ma_ncc int not null,
foreign key(ma_ncc) references nha_cc(ma_ncc)
);

create table chi_tiet_phieu_xuat(
don_gia_xuat double not null,
sl_xuat double not null,
so_px int not null,
ma_vt int not null,
primary key(so_px, ma_vt),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vt) references vat_tu(ma_vt)
);

create table chi_tiet_phieu_nhap(
don_gia_nhap double not null,
sl_nhap double not null,
ma_vt int,
so_pn int,
primary key(ma_vt, so_pn),
foreign key(ma_vt) references vat_tu(ma_vt),
foreign key(so_pn) references phieu_nhap(so_pn)
);

create table chi_tiet_don_dat_hang(
ma_vt int,
so_dh int,
primary key(ma_vt, so_dh),
foreign key(ma_vt) references vat_tu(ma_vt),
foreign key(so_dh) references don_dh(so_dh)
);
