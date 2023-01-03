package com.sustech.service_education.service.video.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Score;
import com.sustech.service_education.entity.Test;
import com.sustech.service_education.entity.Video;
import com.sustech.service_education.mapper.VideoMapper;
import com.sustech.service_education.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper mapper;

    @Override
    public Result getVideo(String course_id, Integer session) {
        String url = mapper.getURLByKey(course_id, session);
        if (url == null || url.isEmpty()) {
            throw new SourceNotFoundException();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
        return Result.ok().message("成功获取视频url").data(map);
    }

    @Override
    public Result storeVideo(String course_id, Integer session, String url, String title, String description, String score) {
        int success = mapper.insertVideo(course_id, session, url, title, description, score);
        if (success == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("视频元数据存储成功").code(200);
        }
    }

    @Override
    public Result getSessionsCount(String course_id) {
        Integer sessionCount = mapper.getSessionsCount(course_id);
        Map<String, Object> map = new HashMap<>();
        map.put("session_count", sessionCount);
        return Result.ok().message("成功获取课程章节数量").data(map);
    }

    @Override
    public Result getSessionInfo(String course_id, Integer session) {
        Video video = mapper.getSessionInfo(course_id, session);
        if (video == null) {
            throw new SourceNotFoundException();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("video", video);
        return Result.ok().message("成功获得课程章节信息").data(map);
    }

    @Override
    public Result setVideoScore(String course_id, Integer session, String score) {
        mapper.setVideoScore(course_id, session, score);
        return Result.ok().code(200).message("视频分数设置成功");
    }

    @Override
    public Result getScore(String course_id, Integer session, String user) {
        Video video = mapper.getSessionInfo(course_id, session);
        int id = video.getId();
        Map<String, Object> map = new HashMap<>();
        if (mapper.getVideoScore(id, user) == null){
            mapper.insertStuSessScore(id,user);
            map.put("video_score", mapper.getVideoScore(id, user));
            map.put("test_score", mapper.getTestScore(id, user));
            return Result.ok().code(200).message("学生成绩初始化成功").data(map);
        }
        else {
            map.put("video_score", mapper.getVideoScore(id, user));
            map.put("test_score", mapper.getTestScore(id, user));
            return Result.ok().code(200).message("获取成绩成功").data(map);
        }
    }

    @Override
    public Result updateVideoScore(String course_id, Integer session, String score, String user) {
        Video video = mapper.getSessionInfo(course_id, session);
        int id = video.getId();
        mapper.updateVideoScore(id, user, score);
        return Result.ok().code(200).message("学生视频分数更改成功");
    }

    @Override
    public Result updateTestScore(String course_id, Integer session, String score, String user) {
        Video video = mapper.getSessionInfo(course_id, session);
        int id = video.getId();
        mapper.updateTestScore(id, user, score);
        return Result.ok().code(200).message("学生测试分数更改成功");
    }

    @Override
    public Result getAllScore(String course_id, Integer session) {
        Video video = mapper.getSessionInfo(course_id, session);
        int id = video.getId();
        List<Score> res = mapper.getScoresBySession(id);
        HashMap<String,Object> map = new HashMap<>();
        if (res.size()!=0){
            map.put("scores",res);
            return Result.ok().code(200).message("获取所有学生成绩成功").data(map);
        }
        return Result.error().message("错误");
    }

    @Override
    public Result postTest(String course_id, Integer session, String questionType, String title, String choices, String correct_answer) {
        Video video = mapper.getSessionInfo(course_id, session);
        if (video!=null){
            int id = video.getId();
            mapper.insertTest(id, questionType, title, choices, correct_answer);
            return Result.ok().code(200).message("题目设置成功");
        }
        else return Result.ok().code(Code.RESOURCE_NOT_FOUND.getCode()).message("找不到此课程");
    }

    @Override
    public Result updateTest(Integer id, String questionType, String title, String choices, String correct_answer) {
        mapper.updateTest(id,questionType,title,choices,correct_answer);
        return Result.ok().code(200).message("题目修改成功");
    }

    @Override
    public Result getAllTestByCourseAndSession(String course_id, Integer session) {
        Video video = mapper.getSessionInfo(course_id, session);
        Map<String,Object> map = new HashMap<>();
        if (video!=null){
            int id = video.getId();
            List<Test> res = mapper.getAllTestBySession(id);
            map.put("Tests",res);
            return Result.ok().code(200).message("题目获取成功").data(map);
        }
        else return Result.ok().code(Code.RESOURCE_NOT_FOUND.getCode()).message("找不到此课程");
    }

    @Override
    public Result getStudentCourseScore(String course_id, String student_id) {
        List<Score> scores = mapper.getStudentCourseScore(course_id, student_id);
        Map<String,Object> map = new HashMap<>();
        if (scores.size() != 0) {
            map.put("scores", scores);
            return Result.ok().code(200).message("学生成绩获取成功").data(map);
        }
        return Result.ok().code(Code.RESOURCE_NOT_FOUND.getCode()).message("学生成绩暂无成绩");
    }
}
