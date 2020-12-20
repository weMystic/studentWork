package com.xan;

import com.xan.mapper.StudentMapper;
import com.xan.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
class StudentApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSql() {
//        Student student = new Student();
//        student.setAge(18);
//        student.setClassId(123);
//        student.setName("mzy");
//        studentMapper.insertByStudent(student);
        List<Student> studentList = studentMapper.listAll();
        for(Student student : studentList) {
            System.out.println(student);
        }
    }

}
