package com.sustech.service_education.service.video.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Video;
import com.sustech.service_education.mapper.VideoMapper;
import com.sustech.service_education.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper mapper;

    @Override
    public Result getVideo(String course_id, Integer session) {
        String url = mapper.getURLByKey(course_id, session);
        if(url==null||url.isEmpty()){
            throw new SourceNotFoundException();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("url",url);
        return Result.ok().message("成功获取视频url").data(map);
    }

    @Override
    public Result storeVideo(String course_id, Integer session, String url, String title, String description) {
        int success = mapper.insertVideo(course_id, session, url, title, description);
        if(success == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("视频元数据存储成功").code(200);
        }
    }

    @Override
    public Result getSessionsCount(String course_id) {
        Integer sessionCount = mapper.getSessionsCount(course_id);
        Map<String,Object> map = new HashMap<>();
        map.put("session_count", sessionCount);
        return Result.ok().message("成功获取课程章节数量").data(map);
    }

    @Override
    public Result getSessionInfo(String course_id, Integer session) {
        Video video = mapper.getSessionInfo(course_id, session);
        if(video==null){
            throw new SourceNotFoundException();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("video", video);
        return Result.ok().message("成功获得课程章节信息").data(map);
    }
}
