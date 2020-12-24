package com.xan.controller;

import com.xan.entity.Student;
import com.xan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("getStudent/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studentMapper.getStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = studentMapper.listAll();
        return students;
    }

    @GetMapping("/studentIds")
    public List<String> studentIds() {
        List<String> studentIds = new ArrayList<>();
        List<Student> students = studentMapper.listAll();
        for (Student student : students) {
            studentIds.add(student.getStudentId());
        }

        return studentIds;
    }


    @PostMapping("/add")
    public void insertStudent(@RequestBody Student student) {
        studentMapper.insertByStudent(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentMapper.deleteStudentById(id);
    }
}
