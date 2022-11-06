package com.sustech.service_education.service.video.impl;

import com.sustech.commonhandler.exception.InsertionFailureException;
import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
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
            throw new InsertionFailureException();
        } else {
            return Result.ok().message("视频元数据存储成功").code(200);
        }
    }
}
