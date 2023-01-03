package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarrageMapper {


    @Insert("insert into barrage (session_id,text,time) values (#{session_id},#{text},#{time})")
    void insertBarrage(int session_id, String text, double time);

    @Select("select * from barrage where session_id = #{session_id}")
    List<Barrage> selectBarrage(int session_id);

}
