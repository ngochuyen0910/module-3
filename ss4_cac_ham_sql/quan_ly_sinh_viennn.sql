use quan_ly_sinh_vien;

-- Hiển thị số lượng sinh viên ở từng nơi
select address, count(id_student) as 'Số lượng học viên'
from student
group by address;

-- Tính điểm trung bình các môn học của mỗi học viên
select student.id_student, student.name_student, avg(mark)
from student
join mark on student.id_student= mark.id_student
group by student.id_student, student.name_student;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select student.id_student, student.name_student, avg(mark)
from student
join mark on student.id_student= mark.id_student
group by student.id_student, student.name_student
having avg (mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select student.id_student, student.name_student, avg(mark)
from student
join mark on student.id_student= mark.id_student
group by student.id_student, student.name_student
having avg (mark) >= all (select avg(mark)from mark group by mark.id_student);

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject`
where credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select mark.id_mark,`subject`.name_subject, `subject`.id_sub , mark.mark
from mark
join `subject` on mark.id_sub= `subject`.id_sub
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên,
-- xếp hạng theo thứ tự điểm giảm dần
select student.id_student, student.name_student, avg(mark) as mark_medium
from student
join mark on student.id_student= mark.id_student
group by student.id_student, student.name_student
order by mark_medium desc;







