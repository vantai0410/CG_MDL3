package com.example.demostudent.service;

import com.example.demostudent.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
}
