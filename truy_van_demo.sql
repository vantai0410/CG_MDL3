 use demo;
 -- 1. Lấy ra thông tin tất cả học viên có lớp học và tên lớp mà các học viên đó đang theo học.
 select student.*, class.class_name
 from student 
 inner join class on student.class_id = class.class_id;
 
 -- 2. Lấy ra thông tin tất cả học viên (bao gồm có và chưa có lớp) và tên lớp (nếu có) mà các học viên đó đang theo học.
 select student.*, class.class_name
 from student 
 left join class on student.class_id = class.class_id ;
 
 -- 3. Lấy thông tin của các học viên tên “Hai” và 'Huynh’.
 select *
 from student
 where student_name like "%hai" or student_name like  "%huynh"; 
 
-- 4. Lấy ra thông tin học viên có điểm lớn hơn 5 .
select *
from student
where student_point > 5;

-- 5. Lấy ra thông tin học viên có họ là “nguyen”
 select *
 from student
 where student_name like "nguyen%";
 
 -- 6. Thông kế số lượng học sinh theo từng loại điểm.
 select student_point, count(student_point) as so_luong
 from student
 group by student_point;
 
 -- 7. Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
 select student_point, count(student_point) as so_luong
 from student
 where student_point > 5
 group by student_point;
 
 -- 8. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng >= 2
  select student_point, count(student_point) as so_luong
 from student
 where student_point > 5
 group by student_point
 having so_luong >=2;
 
-- 9. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên học viên theo alphabet.
select *
from student  
 join class on student.class_id = class.class_id
 where class.class_name = "c1121g1"
 order by substring_index(student.student_name," ",-1) asc;
