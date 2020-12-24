package com.xan.mapper;

import com.xan.entity.Sjoin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SjoinMapper {
    @Select("select * from sjoin")
    @Results({@Result(property = "id", column = "id")
            ,@Result(property = "uid", column = "u_id")
            ,@Result(property = "sid", column = "s_id")
            ,@Result(property = "joinYear", column = "join_year")})
    List<Sjoin> listAll();

    @Delete("delete from sjoin where u_id=#{uid} and s_id=#{sid}")
    int deleteSjoinById(@Param("uid") String uid, @Param("sid") String sid);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into sjoin(u_id, s_id, join_year) VALUES(#{sjoin.uid}, #{sjoin.sid}, #{sjoin.joinYear})")
    void insertBySjoin(@Param("sjoin") Sjoin sjoin);


    @Update("update sjoin set u_id=#{sjoin.uid}, s_id=#{sjoin.sid}, join_year=#{sjoin.joinYear} where id = #{sjoin.id}")
    void updateSjoin(@Param("sjoin") Sjoin sjoin);
}
