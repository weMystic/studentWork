package com.xan.controller;

import com.xan.entity.Class;
import com.xan.entity.Dept;
import com.xan.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class DeptController {

    @Autowired
    DeptMapper deptMapper;


    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("getdept/{id}")
    public Dept getDept(@PathVariable("id") String deptId) {
        return deptMapper.getDeptById(deptId);
    }

    @GetMapping("/depts")
    public List<Dept> getDepts() {
        return deptMapper.listAll();
    }

    @GetMapping("/deptIds")
    public List<String> classIds() {
        List<Dept> depts = deptMapper.listAll();
        List<String> deptIds = new ArrayList<>();
        for (Dept dept : depts) {
            deptIds.add(dept.getDeptId());
        }

        return deptIds;
    }

    @PostMapping("/add")
    public void save(@RequestBody Dept dept) {
        deptMapper.insertByDept(dept);
    }

    @PostMapping("/update")
    public void update(@RequestBody Dept dept) {
        deptMapper.updateDept(dept);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String deptId) {
        deptMapper.deleteDeptById(deptId);
    }
}
