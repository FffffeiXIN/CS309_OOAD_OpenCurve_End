package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Score {
    Integer id;
    String stu_id;
    Integer sess_id;
    float video_score;
    float text_score;
}
