package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface BarrageService {

    Result saveBarrage(String course_id,int session,String text,int time);

    Result getBarrage(String course_id,int session);
}
