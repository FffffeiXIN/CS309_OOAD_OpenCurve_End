package com.sustech.service_education.mapper;

import java.util.List;

import com.sustech.service_education.entity.Score;
import com.sustech.service_education.entity.Test;
import com.sustech.service_education.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

@Mapper
public interface VideoMapper {
    String getURLByKey(String course_id, Integer session);
    int insertVideo(String course_id, Integer session, String url, String title, String description, String score);
    Integer getSessionsCount(String course_id);
    Video getSessionInfo(String course_id, Integer session);
    void setVideoScore(String course_id, Integer session, String score);
    Float getVideoScore(Integer id, String user);
    Float getTestScore(Integer id, String user);
    void updateVideoScore(Integer sess_id, String user, String score);
    void updateTestScore(Integer sess_id, String user, String score);
    void insertStuSessScore(Integer sess_id, String user);
    List<Score> getScoresBySession(Integer sess_id);
    void insertTest(Integer session_id, String questionType, String title, String choices, String correct_answer);
    void updateTest(Integer id, String questionType, String title, String choices, String correct_answer);
    List<Test> getAllTestBySession(Integer sess_id);
}
