package com.xan.service;

import com.xan.entity.Class;

import java.util.List;

public interface ClassService {
    List<Class> listAll();

    int addClass(Class classEntity);

    int deleteClass(List<Integer> ids);

    Class findById(Integer cid);

    int updateClass(Class classEntity);
}
