package com.example.demostudent.repository;

import com.example.demostudent.model.Student;

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
    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
}
