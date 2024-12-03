package com.example.demostudent.repository;

import com.example.demostudent.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static final List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1,"abc",true,4));
        students.add(new Student(2,"def",false,5));
        students.add(new Student(3,"ghi",false,6));
    }

    private static final String FIOND_ALL_STUDENTS_QUERY = "select * from student";
    private static final String INSERT_STUDENT = "insert into student(name,gender,score)" + "values(?,?,?) ";
    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        BaseRepository baseRepository = new BaseRepository(); // tao ket noi
        Connection conn = baseRepository.getConnection();
        try {
            Statement statement = conn.createStatement(); // tao statement
            ResultSet resultSet = statement.executeQuery(FIOND_ALL_STUDENTS_QUERY);  // resault set nhajan ket  qua query ve xu li
            while (resultSet.next()) { //lap qa tung dong query, .next tham chieu qa tung record
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                double score = resultSet.getDouble("score");
                Student student = new Student(id,name,gender,score);
                list.add(student);
            }
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void save(Student student) {
        BaseRepository baseRepository = new BaseRepository(); // tao ket noi
        Connection conn = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setDouble(3,student.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
