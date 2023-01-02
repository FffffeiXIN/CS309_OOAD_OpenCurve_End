package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface BarrageService {

    Result saveBarrage(int video_id,String text,int time);

    Result getBarrage(int video_id);
}
