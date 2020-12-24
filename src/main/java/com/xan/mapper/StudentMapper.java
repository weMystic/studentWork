package com.xan.mapper;

import com.xan.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface StudentMapper {

    @Select("select * from student")
    @Results({@Result(property="studentId",column="student_id"),
            @Result(property="classId",column="class_id")
    })
    List<Student> listAll();

    @Delete("delete from student where student_id=#{studentId}")
    void deleteStudentById(@Param("studentId") String studentId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into student(student_id, name, age, class_id) VALUES(#{student.studentId}, #{student.name}, #{student.age}, #{student.classId})")
    void insertByStudent(@Param("student") Student student);

    @Select("select * from student where student_id=#{studentId}")
    @Results({@Result(property="studentId",column="student_id"),
            @Result(property="classId",column="class_id")
    })
    Student getStudentById(@Param("studentId") String studentId);


    @Update("update student set student_id=#{student.studentId}, name=#{student.name}, age=#{student.age}, class_id=#{student.classId} where id = #{student.id}")
    void updateStudent(@Param("student") Student student);
}
