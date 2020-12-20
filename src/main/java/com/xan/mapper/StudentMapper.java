package com.xan.mapper;

import com.xan.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface StudentMapper {

    @Select("select * from student")
    List<Student> listAll();

    @Delete("delete * from student where id=#{id}")
    int deleteStudentById(@Param("id") Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into student(name, age, class_id) VALUES(#{student.name}, #{student.age}, #{student.classId})")
    void insertByStudent(@Param("student") Student student);

    @Select("select * from student where id=#{sid}")
    Student getStudentById(@Param("id") Integer id);


    @Update("update student set id=#{student.id}, name=#{student.name}, age=#{student.age}, class_id=#{student.classId} where id = #{student.id}")
    void updateStudent(@Param("student") Student student);
}
