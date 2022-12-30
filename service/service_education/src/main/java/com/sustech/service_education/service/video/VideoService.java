package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface VideoService {
    Result getVideo(String course_id, Integer session);
    Result storeVideo(String course_id, Integer session, String url, String title, String description, float score);
    Result getSessionsCount(String course_id);
    Result getSessionInfo(String course_id, Integer session);
    Result setVideoScore(String course_id, Integer session, float score);
    Result getScore(String course_id, Integer session, String user);
    Result updateVideoScore(String course_id, Integer session, float score, String user);
    Result updateTestScore(String course_id, Integer session, float score, String user);
    Result getAllScore(String course_id, Integer session);
    Result postText(String course_id, Integer session, String questionType, String title, String choices, String correct_answer);
    Result updateText(Integer id, String questionType, String title, String choices, String correct_answer);
    Result getAllTestByCourseAndSession(String course_id, Integer session);
}