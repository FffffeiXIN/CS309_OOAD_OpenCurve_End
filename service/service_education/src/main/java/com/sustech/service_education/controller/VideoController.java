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
    public Result uploadVideoMeta(String course_id, Integer session, String url, String title, String description) {
        return videoService.storeVideo(course_id, session, url, title, description);
    }

    @GetMapping("/getSessionsCount")
    public Result getSessionsCount(String course_id) {
        return videoService.getSessionsCount(course_id);
    }

    @GetMapping("/getSessionInfo")
    public Result getSessionInfo(String course_id, Integer session) {
        return videoService.getSessionInfo(course_id, session);
    }
    @PostMapping("/setVideoScore")
    public Result setVideoScore(String course_id, Integer session, float score) {
        return videoService.setVideoScore(course_id, session, score);
    }

    @GetMapping("/getScore")
    public Result getScore(String course_id, Integer session, String user) {
        return videoService.getScore(course_id, session, user);
    }

    @PostMapping("/updateVideoScore")
    public Result updateVideoScore(String course_id, Integer session, float score, String user) {
        return videoService.updateVideoScore(course_id, session, score, user);
    }

    @PostMapping("/updateTestScore")
    public Result updateTestScore(String course_id, Integer session, float score, String user) {
        return videoService.updateTestScore(course_id, session, score, user);
    }
}
