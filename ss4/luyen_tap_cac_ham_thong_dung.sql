use quanlysinhvien;
-- hiển thị tất cả các thông tin môn học có credit lớn nhất
select *
from subject
where credit = (select max(credit) from subject);

-- hiển thị các thông tin môn học có điểm thi lớn nhất
select subject.*, mark.mark
from subject
join mark on subject.subid = mark.subid
where mark.mark = (select max(mark) from mark);

-- hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.studentid, s.studentname, avg(m.mark)
from student s
join mark m on s.studentid = m.studentid
group by s.studentid, s.studentname
order by avg(m.mark) desc;



