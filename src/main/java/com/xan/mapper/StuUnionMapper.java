package com.xan.mapper;

import com.xan.entity.StuUnion;
import com.xan.entity.StuUnionView;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuUnionMapper {

    @Select("select * from stu_union")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "stuUnionId", column = "stu_union_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "establishedYear", column = "established_year")
            ,@Result(property = "place", column = "place")})
    List<StuUnion> listAll();

    @Select("select * from uname_utotal")
    @Results({@Result(property = "uName", column = "Uname")
            ,@Result(property = "uSize", column = "Utotal")})
    List<StuUnionView> listStuUnionview();

    @Delete("delete * from stu_union where stu_union_id=#{id}")
    int deleteStuUnionById(@Param("id") String stuUnionId);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into stu_union(stu_union_id, name, established_year, place) VALUES(#{stuUnion.stuUnionId}, #{stuUnion.name}, #{stuUnion.establishedYear}, #{stuUnion.place})")
    void insertByStuUnion(@Param("stuUnion") StuUnion stuUnion);

    @Select("select * from stu_union where stu_union_id=#{id}")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "stuUnionId", column = "stu_union_id")
            ,@Result(property = "name", column = "name")
            ,@Result(property = "establishedYear", column = "established_year")
            ,@Result(property = "place", column = "place")})
    StuUnion getStuUnionById(@Param("id") String stuUnionId);


    @Update("update stu_union set stu_union_id=#{stuUnion.stuUnionId}, name=#{stuUnion.name}, established_year=#{stuUnion.establishedYear}, place=#{stuUnion.place} where id = #{stuUnion.id}")
    void updateStuUnion(@Param("stuUnion") StuUnion stuUnion);
}
