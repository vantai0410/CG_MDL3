use quanlysinhvien;

 -- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
 select *
 from student
 where StudentName like "H%";
 
 -- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
 select *
 from class
 where month(StartDate) = 12;
 
 -- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
 select *
 from subject
 where Credit >=3 && Credit <= 5;
 
 -- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
 set sql_safe_updates = 0;
 update student
 set ClassID = 2
 where StudentName like "Hung";
 
 select *
 from student;
 
 -- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
 select s.StudentName, sj.SubName, m.Mark
 from student s
 inner join mark m on s.StudentId = m.StudentId
 inner join subject sj on sj.SubId = m.SubId
 order by m.Mark desc, s.StudentName asc;