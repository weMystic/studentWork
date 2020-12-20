package com.xan.service.Impl;

import com.xan.entity.Class;
import com.xan.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements  ClassService{
    @Override
    public List<Class> listAll() {
        return null;
    }

    @Override
    public int addClass(Class classEntity) {
        return 0;
    }

    @Override
    public int deleteClass(List<Integer> ids) {
        return 0;
    }

    @Override
    public Class findById(Integer cid) {
        return null;
    }

    @Override
    public int updateClass(Class classEntity) {
        return 0;
    }
}
