use casestudy_database;

-- 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
update nhan_vien set `status` = 1
where nhan_vien.ma_nhan_vien in (
select * from (
select nv.ma_nhan_vien from nhan_vien nv
left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.ma_nhan_vien not in (
select nv.ma_nhan_vien from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
group by ma_nhan_vien)
) temp);
-- những Nhân viên đã được xoá
select ma_nhan_vien, ho_ten from nhan_vien where `status` = 1;

-- 18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
update khach_hang set `status`= 1
where khach_hang.ma_khach_hang in (
select * from (
select kh.ma_khach_hang from khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) < 2021)
temp);
-- những khách hàng đã được xoá
select ma_khach_hang, ho_ten from khach_hang where `status` = 1;

-- 17.Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang
set khach_hang.ma_loai_khach = 1 where khach_hang.ma_khach_hang in(
select * from (
select khach_hang.ma_khach_hang
from khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach = 'Platinium' and khach_hang.ma_khach_hang in (
select khach_hang.ma_khach_hang 
from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join dich_vu on hop_dong.ma_dich_vu= dich_vu.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where coalesce(dich_vu.chi_phi_thue, 0) + coalesce((hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia), 0) > 10000000
group by khach_hang.ma_khach_hang)
)temp);

-- 19.Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem 
set gia = gia * 2 where dich_vu_di_kem.ma_dich_vu_di_kem in(
select * from(
select dich_vu_di_kem.ma_dich_vu_di_kem
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where hop_dong_chi_tiet.so_luong > 10 and year(hop_dong.ngay_lam_hop_dong) = 2020
)temp);

-- 20.Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_khach_hang as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang
union all
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien;
 