package com.sustech.service_education.mapper;

import java.util.List;

import com.sustech.service_education.entity.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    String getURLByKey(String course_id, Integer session);
    int insertVideo(String course_id, Integer session, String url, String title, String description);
    Integer getSessionsCount(String course_id);
    Video getSessionInfo(String course_id, Integer session);
}
