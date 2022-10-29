package com.sustech.service_education.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    public String getURLByKey(String id);
}
