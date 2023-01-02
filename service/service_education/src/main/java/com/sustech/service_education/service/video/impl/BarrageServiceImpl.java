package com.sustech.service_education.service.video.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Barrage;
import com.sustech.service_education.mapper.BarrageMapper;
import com.sustech.service_education.service.video.BarrageService;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarrageServiceImpl implements BarrageService {

    @Autowired
    BarrageMapper mapper;

    @Override
    public Result saveBarrage(int video_id, String text, int time) {
        mapper.insertBarrage(video_id,text,time);
        return Result.ok();
    }

    @Override
    public Result getBarrage(int video_id) {
        List<Barrage> list = mapper.selectBarrage(video_id);
        list.sort(Comparator.comparingInt(Barrage::getTime));
        Map<String,Object> map=new HashMap<>();
        map.put("barrage",list);
        return Result.ok().code(200).data(map);
    }
}
