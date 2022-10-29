package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/url")
    public Result getVideo(String key){
        return videoService.getVideo(key);
    }


}
