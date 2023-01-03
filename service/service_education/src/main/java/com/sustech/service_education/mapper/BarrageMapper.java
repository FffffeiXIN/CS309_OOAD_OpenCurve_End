package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarrageMapper {


    @Insert("insert into barrage(video_id,text,time) values (#{course_id},#{session},#{text},#{time})")
    void insertBarrage(String course_id,int session,String text,int time);

    @Select("select * from barrage where video_id = #{course_id} and session = #{session}")
    List<Barrage> selectBarrage(String course_id,int session);


}
