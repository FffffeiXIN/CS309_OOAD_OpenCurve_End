package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.video.BarrageService;
import com.sustech.service_education.service.video.impl.BarrageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("barrage")
public class BarrageController {

    @Autowired
    private BarrageServiceImpl service;

    @GetMapping("save")
    public Result saveBarrage(int video_id,String text,int time){
        return service.saveBarrage(video_id,text,time);
    }

    @GetMapping("list")
    public Result getBarrage(int video_id){
        return service.getBarrage(video_id);
    }

}
