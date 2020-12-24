package com.xan.controller;

import com.xan.entity.Major;
import com.xan.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/major")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class MajorController {

    @Autowired
    MajorMapper majorMapper;


    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("getMajor/{id}")
    public Major getMajor(@PathVariable("id") String majorId) {
        return majorMapper.getMajorById(majorId);
    }

    @GetMapping("/majors")
    public List<Major> getMajors() {
        return majorMapper.listAll();
    }

    @GetMapping("/majorIds")
    public List<String> classIds() {
        List<Major> majors = majorMapper.listAll();
        List<String> majorIds = new ArrayList<>();
        for (Major major : majors) {
            majorIds.add(major.getMajorId());
        }

        return majorIds;
    }

    @PostMapping("/add")
    public void save(@RequestBody Major major) {
        majorMapper.insertByMajor(major);
    }

    @PostMapping("/update")
    public void update(@RequestBody Major major) {
        majorMapper.updateMajor(major);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String majorId) {
        majorMapper.deleteMajorById(majorId);
    }
}
