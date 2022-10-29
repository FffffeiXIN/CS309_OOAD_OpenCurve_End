package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface VideoService {
    
    Result getVideo(String course_id, int session);
    
    Result storeVideo(String course_id, int session, String url);
}
