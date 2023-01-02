package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarrageMapper {


    @Insert("insert into barrage(video_id,text,time) values (#{video_id},#{text},#{time})")
    void insertBarrage(int video_id,String text,int time);

    @Select("select * from barrage where video_id = #{video_id}")
    List<Barrage> selectBarrage(int video_id);


}
