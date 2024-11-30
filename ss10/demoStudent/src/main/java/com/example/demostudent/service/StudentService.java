package com.example.demostudent.service;

import com.example.demostudent.model.Student;
import com.example.demostudent.repository.IStudentRepository;
import com.example.demostudent.repository.StudentRepository;

import java.util.Collections;
import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
