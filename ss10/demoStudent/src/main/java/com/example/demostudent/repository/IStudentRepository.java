package com.example.demostudent.repository;

import com.example.demostudent.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
}
