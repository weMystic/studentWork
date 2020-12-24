package com.xan.mapper;

import com.xan.entity.Major;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MajorMapper {

    @Select("select * from major")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "majorId", column = "major_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "deptId", column = "dept_id")})
    List<Major> listAll();

    @Delete("delete from major where major_id=#{id}")
    int deleteMajorById(@Param("id") String majorId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into major(major_id, name, dept_id) VALUES(#{major.majorId}, #{major.name}, #{major.deptId})")
    void insertByMajor(@Param("major") Major major);

    @Select("select * from major where major_id=#{id}")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "majorId", column = "major_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "deptId", column = "dept_id")})
    Major getMajorById(@Param("id") String majorId);

    @Update("update major set major_id=#{major.majorId}, name=#{major.name}, dept_id=#{major.deptId} where id = #{major.id}")
    void updateMajor(@Param("major") Major major);
}
