package com.xan.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

import com.xan.entity.Class;

public interface ClassMapper {

    @Select("select * from class")
    @Results({@Result(property = "id", column = "id")
             ,@Result(property = "classId", column = "class_id")
             ,@Result(property = "yearOfEnrollment", column = "year_of_enrollment")
             ,@Result(property = "size", column = "size")
             ,@Result(property = "majorId", column = "major_id")})
    List<Class> listAll();

    @Delete("delete from class where class_id=#{id}")
    int deleteClassById(@Param("id") String classid);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into class(class_id, year_of_enrollment, size, major_id) VALUES(#{class.classId}, #{class.yearOfEnrollment}, #{class.size}, #{class.majorId})")
    void insertByStudent(@Param("class") Class classs);

    @Select("select * from class where class_id=#{id}")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "classId", column = "class_id")
            ,@Result(property = "yearOfEnrollment", column = "year_of_enrollment")
            ,@Result(property = "size", column = "size")
            ,@Result(property = "majorId", column = "major_id")})
    Class getClassById(@Param("id") String classid);


    @Update("update class set class_id=#{classs.classId}, year_of_enrollment=#{classs.yearOfEnrollment}, size=#{classs.size}, major_id=#{classs.majorId} where id = #{classs.id}")
    void updateClass(@Param("classs") Class classs);
}
