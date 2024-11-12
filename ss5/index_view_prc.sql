use demo;

CREATE INDEX idex_student_email ON student(student_email);
DROP INDEX idex_student_email ON student;



CREATE VIEW view_student AS
SELECT student_id, student_name
FROM student;
DROP VIEW view_student;

DELIMITER //
CREATE PROCEDURE findByName
 ( student_name VARCHAR(50))
BEGIN
    SELECT * 
    FROM student 
    WHERE student_name LIKE CONCAT('%', student_name);
END //
DELIMITER ;

call findByName("huynh");



