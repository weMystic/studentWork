package com.xan.mapper;

import com.xan.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper {
    @Select("select * from dept")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "deptId", column = "dept_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "place", column = "place")
            ,@Result(property = "size", column = "size")})
    List<Dept> listAll();

    @Delete("delete  from dept where dept_id=#{id}")
    int deleteDeptById(@Param("id") String deptId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into dept(dept_id, name, place, size) VALUES(#{dept.deptId}, #{dept.name}, #{dept.place}, #{dept.size})")
    void insertByDept(@Param("dept") Dept dept);

    @Select("select * from dept where dept_id=#{id}")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "deptId", column = "dept_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "place", column = "place")
            ,@Result(property = "size", column = "size")})
    Dept getDeptById(@Param("id") String deptId);


    @Update("update dept set dept_id=#{dept.deptId}, name=#{dept.name}, place=#{dept.place},size=#{dept.size} where id = #{dept.id}")
    void updateDept(@Param("dept") Dept dept);
}
