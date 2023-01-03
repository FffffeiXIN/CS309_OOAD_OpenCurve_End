package com.sustech.service_education.service.video;

import com.sustech.commonutils.Result;

public interface BarrageService {

    Result saveBarrage(int session_id, String text, double time);

    Result getBarrage(int session_id);
}
