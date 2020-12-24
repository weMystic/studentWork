package com.xan.controller;

import com.xan.entity.Sjoin;
import com.xan.mapper.SjoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sJoin")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class SjoinController {

    @Autowired
    SjoinMapper sjoinMapper;

    @GetMapping("/sjoins")
    public List<Sjoin> getSjoins() {
        List<Sjoin> sjoins = sjoinMapper.listAll();
        return sjoins;
    }


    @PostMapping("/add")
    public void insertSjoin(@RequestBody Sjoin sjoin) {
        sjoinMapper.insertBySjoin(sjoin);
    }

    @PostMapping("/update")
    public void updateSjoin(@RequestBody Sjoin sjoin) {
        sjoinMapper.updateSjoin(sjoin);
    }

    @DeleteMapping("/delete/{uid}/{sid}")
    public void deleteSjoin(@PathVariable("uid") String uid, @PathVariable("sid") String sid) {
        sjoinMapper.deleteSjoinById(uid, sid);
    }
}
