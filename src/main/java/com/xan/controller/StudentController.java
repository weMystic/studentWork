package com.xan.controller;

import com.xan.entity.Student;
import com.xan.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("getStudent/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return studentMapper.getStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getUsers() {
        return studentMapper.listAll();
    }

    @PostMapping("/add")
    public void save(@RequestBody Student student) {
        studentMapper.insertByStudent(student);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student) {
        studentMapper.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        studentMapper.deleteStudentById(id);
    }
}
