package com.sustech.service_education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    String getURLByKey(String course_id, int session);
    int insertVideo(String course_id, int session, String url);
}
