package com.xan.controller;

import com.xan.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.xan.entity.Class;


@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ClassController {

    @Autowired
    ClassMapper classMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("getClass/{id}")
    public Class getClass(@PathVariable("id") String classId) {
        return classMapper.getClassById(classId);
    }

    @GetMapping("/classes")
    public List<Class> getClasses() {
        return classMapper.listAll();
    }

    @GetMapping("/classIds")
    public List<String> classIds() {
        List<Class> Classes = classMapper.listAll();
        List<String> classIds = new ArrayList<>();
        for (Class classObj : Classes) {
            classIds.add(classObj.getClassId());
        }

        return classIds;
    }

    @PostMapping("/add")
    public void save(@RequestBody Class classObj) {
        classMapper.insertByStudent(classObj);
    }

    @PostMapping("/update")
    public void update(@RequestBody Class classObj) {
        System.out.println(classObj);
        classMapper.updateClass(classObj);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String classId) {
        classMapper.deleteClassById(classId);
    }
}
