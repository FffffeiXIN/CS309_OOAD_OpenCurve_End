package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/url")
    public Result getVideo(String course_id, Integer session){
        return videoService.getVideo(course_id, session);
    }
    @PostMapping("/uploadVideoMeta")
    public Result uploadVideoMeta(String course_id, Integer session, String url) {
        return videoService.storeVideo(course_id, session, url);
    }

}
