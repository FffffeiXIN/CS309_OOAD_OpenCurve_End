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
    public Result saveBarrage(int session_id, String text, double time) {
        mapper.insertBarrage(session_id, text, time);
        return Result.ok().code(200).message("弹幕存储成功");
    }

    @Override
    public Result getBarrage(int session_id) {
        List<Barrage> list = mapper.selectBarrage(session_id);
        Map<String, Object> map = new HashMap<>();
        map.put("barrages", list);
        return Result.ok().code(200).data(map);
    }
}
