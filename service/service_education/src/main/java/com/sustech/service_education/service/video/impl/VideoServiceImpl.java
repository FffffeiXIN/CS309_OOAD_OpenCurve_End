package com.sustech.service_education.service.video.impl;

import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
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
    public Result getVideo(String key) {
        String url = mapper.getURLByKey(key);
        if(url==null||url.isEmpty()){
            throw new SourceNotFoundException();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("url",url);
        return Result.ok().message("成功获取视频url").data(map);
    }
}
