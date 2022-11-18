package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Notification {

    Integer id;

    String title;

    String course_id;

    String teacher_id;

    String modified_time;

    String content;
}
