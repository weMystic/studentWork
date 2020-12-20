package com.xan.service.Impl;

import com.xan.entity.Student;
import com.xan.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> listAll() {
        return null;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(List<Integer> ids) {
        return 0;
    }

    @Override
    public Student findById(Integer sid) {
        return null;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }
}
