package com.xan.service;

import com.xan.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();

    int addStudent(Student student);

    int deleteStudent(List<Integer> ids);

    Student findById(Integer sid);

    int updateStudent(Student student);
}
