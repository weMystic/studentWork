package com.xan.controller;

import com.xan.entity.Major;
import com.xan.entity.StuUnion;
import com.xan.entity.StuUnionView;
import com.xan.mapper.StuUnionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stuUnion")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class StuUnionController {

    @Autowired
    StuUnionMapper stuUnionMapper;


    @GetMapping("getStuUnion/{id}")
    public StuUnion getStuUnion(@PathVariable("id") String stuUnionId) {
        return stuUnionMapper.getStuUnionById(stuUnionId);
    }

    @GetMapping("/stuUnions")
    public List<StuUnion> getStuUnions() {
        return stuUnionMapper.listAll();
    }

    @GetMapping("/stuUnionView")
    public List<StuUnionView> getStuUnionView() {
        return stuUnionMapper.listStuUnionview();
    }

    @GetMapping("/stuUnionIds")
    public List<String> stuUnionIds() {
        List<StuUnion> stuUnions = stuUnionMapper.listAll();
        List<String> stuUnionIds = new ArrayList<>();
        for (StuUnion stuUnion : stuUnions) {
            stuUnionIds.add(stuUnion.getStuUnionId());
        }

        return stuUnionIds;
    }

    @PostMapping("/add")
    public void save(@RequestBody StuUnion stuUnion) {
        stuUnionMapper.insertByStuUnion(stuUnion);
    }

    @PostMapping("/update")
    public void update(@RequestBody StuUnion stuUnion) {
        stuUnionMapper.updateStuUnion(stuUnion);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String stuUnionId) {
        stuUnionMapper.deleteStuUnionById(stuUnionId);
    }
}
